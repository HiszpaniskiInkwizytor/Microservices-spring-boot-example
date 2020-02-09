package com.gft.person;
import com.gft.person.processors.PeselValidator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeselValidatorTests {

    @Test
    public void peselValidator_NullValueGiven_ShouldReturnFalse(){
        PeselValidator pesel_validator = new PeselValidator();
        pesel_validator.isValid(null);
    }

    @Test
    public void checkSum_ValidPeselGiven_ShouldReturnTrue(){
        //given
        String pesel = TestDataStructures.createPerson().get().getPesel();
        //when
        //then
        PeselValidator peselValidator = new PeselValidator();
        boolean what = peselValidator.checkSum(pesel);
        assertThat(what).isEqualTo(true);
    }
}
