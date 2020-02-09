package com.gft.person.request;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class RetardRequest {
    Long id;
    String pesel;
}
