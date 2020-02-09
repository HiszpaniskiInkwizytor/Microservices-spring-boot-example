package com.gft.person;

import com.gft.person.domain.Person;

import java.util.Optional;

public class TestDataStructures {

    static Optional<Person> createPerson(){
        return Optional.of(Person.builder()
                .id(1L)
                .firstName("Dariusz")
                .lastName("Yourmomgay")
                .pesel("69121944789")
                .build());
    }
}
