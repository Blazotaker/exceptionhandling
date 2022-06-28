package com.blazotaker.validations.excepcion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
//Errores para las excepciones en la lógica de negocio
public class ErrorDetails {
    private LocalDate date;
    private String message ;
    private String errorDetails;
}
