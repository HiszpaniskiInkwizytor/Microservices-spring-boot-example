package com.gft.person;

import com.gft.person.domain.Person;
import com.gft.person.domain.Retard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class TestDataStructures {

    static Optional<Person> createPerson(){
        return Optional.of(Person.builder()
                .id(1L)
                .firstName("Dariusz")
                .lastName("Yourmomgay")
                .pesel("69121944789")
                .build());
    }
    static Optional<Retard> createRetard(){
        return Optional.of(Retard.builder()
                .id(1L)
                .pesel("69121944789")
                .build());
    }

    static Optional<Retard> createSecondRetard(){
        return Optional.of(Retard.builder()
                .id(2L)
                .pesel("69121944789")
                .build());
    }

    static List<Retard> createRetardList(){
        ArrayList<Retard> retardList = new ArrayList<>();
        retardList.add(createRetard().get());
        retardList.add(createSecondRetard().get());
        return retardList;
    }
}
