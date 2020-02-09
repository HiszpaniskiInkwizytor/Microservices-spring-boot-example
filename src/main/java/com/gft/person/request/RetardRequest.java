package com.gft.person.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class RetardRequest {
    Long id;
    String pesel;
}
