package com.gft.person.services;

import com.gft.person.command.PersonConverter;
import com.gft.person.domain.Person;
import com.gft.person.domain.Retard;
import com.gft.person.repositories.PersonRepository;
import com.gft.person.repositories.RetardRepository;
import com.gft.person.response.PersonResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private RetardRepository retardRepository;
    private PersonConverter personConverter;

    public PersonService(PersonRepository personRepository, RetardRepository retardRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.retardRepository = retardRepository;
        this.personConverter = personConverter;
    }

    public PersonResponse getPersonById(Long id) {
        return personRepository.findById(id).isPresent() ? personConverter.personToPersonResponse(personRepository.findById(id).get()) : null;
    }

    public Person savePerson(Person person){
        if(person.isRetard())
        {
            retardRepository.save(personIntoRetardTransformer(person));
        }
        return personRepository.save(person);
    }

    public Optional<Person> findById(Long id){
        return personRepository.findById(id);
    }

    public List<Person> getAllRetards(){
        List<Retard> retards = retardRepository.findAll();
        return retards.stream()
                .map(retard -> personRepository.findByPesel(retard.getPesel()))
                .collect(Collectors.toList());
    }

    private Retard personIntoRetardTransformer(Person person){
        return Retard.builder()
                .pesel(person.getPesel())
                .build();
    }
}
