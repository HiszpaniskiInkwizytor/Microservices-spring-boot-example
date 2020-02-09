package com.gft.person.command;

import com.gft.person.domain.Person;
import com.gft.person.request.PersonRequest;
import com.gft.person.response.PersonResponse;

public class PersonConverter {
    public Person personRequestToPerson(PersonRequest personRequest){
        return Person.builder()
                .firstName(personRequest.getFirstName())
                .lastName(personRequest.getLastName())
                .pesel(personRequest.getPesel())
                .id(personRequest.getId())
                .memberFrom(personRequest.getMemberFrom())
                .retard(personRequest.isRetard())
                .build();
    }

    public PersonResponse personToPersonResponse(Person person){
        return PersonResponse.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .pesel(person.getPesel())
                .id(person.getId())
                .memberFrom(person.getMemberFrom())
                .retard(person.isRetard())
                .build();
    }
}
