package baseball.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerNumberFormatValidatorTest {
    @Test
    public void testValidatorValueWithValid(){
        //given
        String givenNum = "124";
        //when
        //then
        assertEquals(PlayerNumberFormatValidator.validate(givenNum), true);
    }

    @Test
    public void testValidatorValueWithInvalidNumber(){
        //given
        String givenNum = "12464";
        //when
        //then
        assertEquals(PlayerNumberFormatValidator.validate(givenNum), false);
    }

    @Test
    public void testValidatorValueWithInvalidCharacters(){
        //given
        String givenNum = "sdagbjklew";
        //when
        //then
        assertEquals(PlayerNumberFormatValidator.validate(givenNum), false);
    }
}