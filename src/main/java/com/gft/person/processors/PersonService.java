package com.gft.person.processors;

import com.gft.person.domain.Person;
import com.gft.person.domain.Retard;
import com.gft.person.repositories.PersonRepository;
import com.gft.person.repositories.RetardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private RetardRepository retardRepository;
    public PersonService(PersonRepository personRepository, RetardRepository retardRepository) {
        this.personRepository = personRepository;
        this.retardRepository = retardRepository;
    }

    public Person getPersonById(Long id) {
        if (personRepository.findById(id).isPresent())
            return personRepository.findById(id).get();
        return Person.builder().firstName("Nie").lastName("istnieje").pesel("taki person.").build();
    }

    public Person savePerson(Person person){
        if(person.isRetard())
        {
            retardRepository.save(personIntoRetardTransformer(person));
        }
        person.setMemberFrom(LocalDateTime.now());
        return personRepository.save(person);
    }

    public Optional<Person> findById(Long id){
        return personRepository.findById(id);
    }

    public List<Person> getAllRetards(){
        List<Retard> retards = retardRepository.findAll();
        return retards.stream().map(retard -> personRepository.findByPesel(retard.getPesel())).collect(Collectors.toList());
    }

    public Retard personIntoRetardTransformer(Person person){
        return Retard.builder()
                .pesel(person.getPesel())
                .build();
    }
}
