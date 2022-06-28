package com.blazotaker.validations.controller;

import com.blazotaker.validations.entity.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {


    @PostMapping("/person")
    public String check(@Valid @RequestBody Person person){

        return "Hola";
    }
}
