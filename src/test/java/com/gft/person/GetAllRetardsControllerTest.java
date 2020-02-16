package com.gft.person;
import com.gft.person.command.PersonConverter;
import com.gft.person.controller.GetAllRetardsController;
import com.gft.person.domain.Person;
import com.gft.person.domain.Retard;
import com.gft.person.repositories.PersonRepository;
import com.gft.person.repositories.RetardRepository;
import com.gft.person.services.PersonService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

public class GetAllRetardsControllerTest {
    private RetardRepository retardRepository = mock(RetardRepository.class);
    private PersonRepository personRepository = mock(PersonRepository.class);

    private PersonConverter personConverter = new PersonConverter();
    private PersonService personService = new PersonService(personRepository, retardRepository, personConverter);
    private GetAllRetardsController getAllRetardsController = new GetAllRetardsController(personService);

    @Test
    public void getAllRetards() {
        //given
        List<Retard> retardList = TestDataStructures.createRetardList();
        when(retardRepository.findAll()).thenReturn(retardList);
        when(retardRepository.findAll()).thenReturn(retardList);
        //when
        List<Person> receivedRetards = getAllRetardsController.getAllRetards();
        //then
        assertThat(receivedRetards.get(0).getPesel()).isEqualTo(retardList.get(0).getPesel());
        assertThat(receivedRetards).isEqualTo(retardList.get(1).getPesel());
    }

    @Test
    public void getPersonTest_NullValuesGiven_ShouldHandleNull(){
        //given
        Optional<Retard> retard = TestDataStructures.createRetard();
        when(retardRepository.findById(any())).thenReturn(retard);
        //when
        List<Person> retardsControllerAllRetards = getAllRetardsController.getAllRetards();
        //then
        assertThat(retardsControllerAllRetards).isEqualTo(retard.get().getPesel());
    }

}
