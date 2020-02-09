package com.gft.person.controller;

import com.gft.person.domain.Person;
import com.gft.person.processors.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddPersonController {

    private PersonService personService;

    public AddPersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/dodaj", method = RequestMethod.GET)
    public void addPerson(){
        Person person = Person.builder()
                .lastName("Dupa")
                .pesel("997")
                .firstName("Ten numer to kłopoty")
                .build();
        personService.savePerson(person);
    }
}
