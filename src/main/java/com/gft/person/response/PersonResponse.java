package com.gft.person.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class PersonResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDateTime memberFrom;
    private boolean retard;

}
