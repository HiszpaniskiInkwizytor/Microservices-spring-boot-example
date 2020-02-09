package com.gft.person;

import com.gft.person.domain.Person;
import com.gft.person.repositories.PersonRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContextConfigurationTests {
	private Long person1ActualId;

	@Autowired
	private
	PersonRepository personRepository;

	@Before
	public void setUp() {
		person1ActualId = personRepository.save(Person
				.builder()
				.firstName("Damian")
				.lastName("Mocher")
				.pesel("70062267884")
				.build()).getId();
	}

	@After
	public void tearDown(){
		personRepository.deleteAll();
	}

	@Test
	public void testIfPersonWasAddedProperly(){
		assertThat(personRepository.findById(person1ActualId).get().getFirstName())
				.isEqualTo("Damian");
	}

	@Test
	public void testIfRepositoryHaveProperSize(){
		assertThat(personRepository.count()).isEqualTo(1L);
	}
}
