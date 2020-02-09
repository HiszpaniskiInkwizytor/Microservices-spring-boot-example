package com.gft.person.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class RetardResponse {
    Long id;
    String pesel;
}
