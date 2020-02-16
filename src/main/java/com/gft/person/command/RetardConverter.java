package com.gft.person.command;

import com.gft.person.domain.Retard;
import com.gft.person.request.RetardRequest;
import com.gft.person.response.RetardResponse;
import org.springframework.stereotype.Component;

@Component
public class RetardConverter {
    Retard retardRequestToRetard(RetardRequest retardRequest){
        return Retard.builder()
                .pesel(retardRequest.getPesel())
                .id(retardRequest.getId())
                .build();
    }

    RetardResponse retardToRetardResponse(Retard retard){
        return RetardResponse.builder()
                .id(retard.getId())
                .pesel(retard.getPesel())
                .build();
    }
}
