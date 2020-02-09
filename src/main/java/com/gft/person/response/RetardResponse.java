package com.gft.person.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class RetardResponse {
    Long id;
    String pesel;
}
