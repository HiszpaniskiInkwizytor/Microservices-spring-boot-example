package com.gft.person.controller;

import com.gft.person.DBObjects.Person;
import com.gft.person.processors.PersonService;
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
    public Person getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }
}
