package com.gft.person.repositories;

import com.gft.person.DBObjects.Retard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetardRepository extends CrudRepository <Retard, Long> {
    List<Retard> findAll();
}
