package com.blazotaker.validations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//Mensaje de error para los campos
public class ErrorMessageDto {
    private String object;
    private String field;
    private String message;
    private Object rejectedValue;
}
