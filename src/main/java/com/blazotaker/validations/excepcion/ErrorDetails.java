package com.blazotaker.validations.excepcion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//Errores para las excepciones en la lógica de negocio
public class ErrorDetails {
    private LocalDateTime date;
    private String message ;
    private String errorDetails;
}
