package com.gft.person;
import com.gft.person.processors.PeselValidator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeselValidatorTests {

    @Test
    public void peselValidator_NullValueGiven_ShouldReturnFalse(){
        //given
        PeselValidator peselValidator = new PeselValidator();

        //when
        boolean isPeselValid = peselValidator.isValid(null);

        //then
        assertThat(isPeselValid).isEqualTo(false);
    }

    @Test
    public void checkSum_ValidPeselGiven_ShouldReturnTrue(){
        //given
        String pesel = TestDataStructures.createPerson().get().getPesel();
        PeselValidator peselValidator = new PeselValidator();

        //when
        boolean isCheckSumValid = peselValidator.checkSum(pesel);

        //then
        assertThat(isCheckSumValid).isEqualTo(true);
    }
}
