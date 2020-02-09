package com.gft.person;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
public class ApplicationControllerTests {

    @LocalServerPort
    private int port;

    @Test
    public void getPersonById_ValidPersonIdGiven_ShouldReturnSame(){

    }
}
