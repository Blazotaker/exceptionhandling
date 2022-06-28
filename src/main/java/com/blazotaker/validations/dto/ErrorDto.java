package com.blazotaker.validations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//Error general con la lista de error de campos
public class ErrorDto {
    public String statusCode;
    public String message;
    public List<ErrorMessageDto> errors;
}
