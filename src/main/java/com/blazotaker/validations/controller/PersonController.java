package com.blazotaker.validations.controller;

import com.blazotaker.validations.entity.Person;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {


    @PostMapping("/person")
    public String check(@Valid @RequestBody Person person){

        return "Hola";
    }

    @GetMapping("/checkerror")
    public String checkerror(){
        System.out.println(0/0);
        return "Hola";
    }
}
