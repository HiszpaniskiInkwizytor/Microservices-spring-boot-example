package com.gft.person;

import com.gft.person.command.PersonConverter;
import com.gft.person.controller.GetPersonController;
import com.gft.person.domain.Person;
import com.gft.person.repositories.PersonRepository;
import com.gft.person.repositories.RetardRepository;
import com.gft.person.response.PersonResponse;
import com.gft.person.services.PersonService;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

public class GetPersonControllerTests {
    private RetardRepository retardRepository = mock(RetardRepository.class);
    private PersonRepository personRepository = mock(PersonRepository.class);

    private PersonConverter personConverter = new PersonConverter();
    private PersonService personService = new PersonService(personRepository, retardRepository, personConverter);
    private GetPersonController getPersonController = new GetPersonController(personService);

    @Test
    public void getPersonTest(){
        //given
        Optional<Person> person = TestDataStructures.createPerson();
        when(personRepository.findById(1L)).thenReturn(person);
        //when
        PersonResponse personResponse = getPersonController.getPersonById(1L);
        //then
        assertThat(personResponse.getFirstName()).isEqualTo(person.get().getFirstName());
    }
}
