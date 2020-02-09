package com.gft.person.repositories;

import com.gft.person.DBObjects.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository <Person, Long> {
    public Person findByPesel(String pesel);
}
