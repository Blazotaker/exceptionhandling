package com.blazotaker.validations.excepcion;

import com.blazotaker.validations.dto.ErrorDto;
import com.blazotaker.validations.dto.ErrorMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
//java.util.logging.Logger
public class GeneralException extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralException.class);

    //RECORDAR: ResponseEntityExceptionHandler es una clase que heredamos porque es una plantilla proporcionada para usar el manejo de excepciones controladas
    @Override
    //@ExceptionHandler(MethodArgumentNotValidException.class) como estoy sobrescribiendo el de ResponseEntityExceptionHandler no es necesario indicar esto
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        System.out.println();
        return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST.toString(),"Field Error",
                listValidationError(ex.getFieldErrors())));

    }


    public List<ErrorMessageDto> listValidationError(List<FieldError> fieldErrors){
        return fieldErrors.stream()
                .map(fieldError -> {
                    ErrorMessageDto errorMessageDto = new ErrorMessageDto();
                    errorMessageDto.setMessage(fieldError.getDefaultMessage());
                    errorMessageDto.setField(fieldError.getField());
                    errorMessageDto.setObject(fieldError.getObjectName());
                    errorMessageDto.setRejectedValue(fieldError.getRejectedValue());
                    return errorMessageDto;
                }).collect(Collectors.toList());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllUncaughtException(Exception exception,
                                                               WebRequest request){
        LOGGER.error(exception.getMessage(),exception);
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), "Unexpected error has occurred", exception.getLocalizedMessage());
        return ResponseEntity.internalServerError().body(errorDetails);
    }
}
