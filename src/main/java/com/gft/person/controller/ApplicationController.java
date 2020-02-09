package com.gft.person.controller;

import com.gft.person.processors.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    private PersonService personService;

    public ApplicationController(PersonService personService) {
        this.personService = personService;
    }

}
