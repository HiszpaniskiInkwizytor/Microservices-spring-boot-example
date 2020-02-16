package com.gft.person;
import com.gft.person.command.PersonConverter;
import com.gft.person.controller.GetPersonController;
import com.gft.person.controller.SavePersonController;
import com.gft.person.domain.Person;
import com.gft.person.repositories.PersonRepository;
import com.gft.person.repositories.RetardRepository;
import com.gft.person.response.PersonResponse;
import com.gft.person.services.PersonService;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.*;


public class SavePersonControllerTest {
    private RetardRepository retardRepository = mock(RetardRepository.class);
    private PersonRepository personRepository = mock(PersonRepository.class);

    private PersonConverter personConverter = new PersonConverter();
    private PersonService personService = new PersonService(personRepository, retardRepository, personConverter);
    private SavePersonController savePersonController = new SavePersonController(personService);

    @Test
    public void getPersonTest(){
        //given
        Optional<Person> person = TestDataStructures.createPerson();
        //when
        Person personResponse = savePersonController.savePerson(Person.builder().build());
        //then
        assertThat(personResponse.getFirstName()).isEqualTo(person.get().getFirstName());
    }
}
