package com.gft.person.controller;

import com.gft.person.DBObjects.Person;
import com.gft.person.processors.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllRetardsController {
    private PersonService personService;

    public GetAllRetardsController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/retards", method = RequestMethod.GET)
    public List<Person> getAllRetards(){
        return personService.getAllRetards();
    }
}
