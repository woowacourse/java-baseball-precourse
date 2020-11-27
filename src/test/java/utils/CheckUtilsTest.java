package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckUtilsTest {

    @Test
    public void checkLength(){

        String inputNumber = "123";
        String wrongNumber = "12";
        assertTrue(CheckUtils.isLengthThree(inputNumber));
        assertFalse(CheckUtils.isLengthThree(wrongNumber));
    }

    @Test
    public void checkDigit(){
        String inputNumber = "123";
        String wrongNumber = "a12";
        assertTrue(CheckUtils.isDigit(inputNumber));
        assertFalse(CheckUtils.isDigit(wrongNumber));
    }

}