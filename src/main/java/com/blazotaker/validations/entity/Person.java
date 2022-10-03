package com.blazotaker.validations.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Person {

    //Validation de hibernate, que se pone @Valid en @PostMapping cuando vas a trabajar con objectos como parametro en el controlador
    @NotNull(message = "no null")
    @NotEmpty(message = "no empty")

    private String Id;

    @NotNull(message = "no null")
    @NotEmpty(message = "no empty")
    @Size(min = 4, max = 15)
    private String firstName;

    @NotNull(message = "no null")
    @NotEmpty(message = "no empty")
    private String lastName;

    @NotNull(message = "no null")
    @NotEmpty(message = "no empty")
    private String address;

}
