package com.gft.person.controller;

import com.gft.person.response.PersonResponse;
import com.gft.person.services.PersonService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPersonController {
    private PersonService personService;

    public GetPersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    public PersonResponse getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }
}
