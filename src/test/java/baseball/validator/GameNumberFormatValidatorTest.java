package baseball.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameNumberFormatValidatorTest {
    @Test
    public void testValidatorValueWithValidOne(){
        String givenNum = "1";
        assertEquals(GameNumberFormatValidator.validate(givenNum), true);
    }

    @Test
    public void testValidatorValueWithValidTwo(){
        String givenNum = "2";
        assertEquals(GameNumberFormatValidator.validate(givenNum), true);
    }

    @Test
    public void testValidatorValueWithInvalidNumber(){
        String givenNum = "12464";
        assertEquals(GameNumberFormatValidator.validate(givenNum), false);
    }

    @Test
    public void testValidatorValueWithInvalidCharacters(){
        String givenNum = "sdagbjklew";
        assertEquals(GameNumberFormatValidator.validate(givenNum), false);
    }
}