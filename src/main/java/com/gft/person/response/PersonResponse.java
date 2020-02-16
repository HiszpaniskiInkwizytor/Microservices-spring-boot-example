package com.gft.person.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PersonResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private boolean retard;
}
