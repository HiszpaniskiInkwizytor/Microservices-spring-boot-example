package com.gft.person;


import com.gft.person.domain.Person;
import com.gft.person.controller.*;
import com.gft.person.processors.PersonService;
import com.gft.person.repositories.PersonRepository;
import com.gft.person.repositories.RetardRepository;
import org.junit.Test;
import org.mockito.ArgumentCaptor;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

import static org.assertj.core.api.Assertions.*;

public class ApplicationControllerUnitTests {

    PersonRepository personRepository = mock(PersonRepository.class);
    RetardRepository retardRepository = mock(RetardRepository.class);
    PersonService personService = new PersonService(personRepository, retardRepository);
    ApplicationController applicationController = new ApplicationController(personService);
    AddPersonController addPersonController = new AddPersonController(personService);
    GetAllRetardsController getAllRetardsController = new GetAllRetardsController(personService);
    GetPersonController getPersonController = new GetPersonController(personService);
    SavePersonController savePersonController = new SavePersonController(personService);


    @Test
    public void getPersonById(){
        //given
        when(personRepository.findById(TestDataStructures
                     .createPerson()
                     .get()
                     .getId()))
                .thenReturn(TestDataStructures.createPerson());

        //when
        Person endpoint = getPersonController.getPersonById(1L);

        //then
        assertThat(TestDataStructures.createPerson().get()).isEqualTo(endpoint);
    }

    @Test
    public void savePerson_ValidPersonGiven_ShouldReturnSameObjectAsGiven(){
        //given
        when(personRepository.save(any())).thenReturn(TestDataStructures.createPerson().get());
        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        Person captured;

        //when
        savePersonController.savePerson(TestDataStructures.createPerson().get());
        verify(personRepository).save(captor.capture());

        //then
        captured = captor.getValue();
        assertThat(captured).isEqualTo(TestDataStructures.createPerson().get());
    }
}
