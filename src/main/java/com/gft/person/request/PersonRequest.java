package com.gft.person.request;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class PersonRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDateTime memberFrom;
    private boolean retard;

}
