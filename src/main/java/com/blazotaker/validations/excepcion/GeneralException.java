package com.blazotaker.validations.excepcion;

import com.blazotaker.validations.dto.ErrorDto;
import com.blazotaker.validations.dto.ErrorMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GeneralException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationMessage(MethodArgumentNotValidException ex){
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
}
