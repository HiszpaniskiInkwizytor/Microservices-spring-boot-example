package com.gft.person.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private boolean retard;

}
