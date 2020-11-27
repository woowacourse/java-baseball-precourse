package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputUtilsTest {

    @Test
    public void 입력값이_숫자인지() {
        // given, when
        String input1 = "123";
        String input2 = "일이삼";

        // then
        assertTrue(InputUtils.isDigit(input1));
        assertFalse(InputUtils.isDigit(input2));
    }

    @Test
    public void 입력값이_3자리인지() {
        // given, when
        String input1 = "123";
        String input2 = "1234";
        String input3 = "12";

        // then
        assertTrue(InputUtils.isInputLengthEqualsToBaseballLength(input1));
        assertFalse(InputUtils.isInputLengthEqualsToBaseballLength(input2));
        assertFalse(InputUtils.isInputLengthEqualsToBaseballLength(input3));
    }

    @Test
    public void 입력값의_각각의_숫자가_1부터_9까지인지() {
        // given, when
        String input1 = "123";
        String input2 = "023";
        String input3 = "890";

        // then
        assertTrue(InputUtils.isDigitInBaseballRange(input1));
        assertFalse(InputUtils.isDigitInBaseballRange(input2));
        assertFalse(InputUtils.isDigitInBaseballRange(input3));
    }

    @Test
    public void 입력값이_1혹은_2인지() {
        // given, when
        String input1 = "1";
        String input2 = "3";
        String input3 = "2";

        // then
        assertTrue(InputUtils.isDigitInMenuRange(input1));
        assertFalse(InputUtils.isDigitInMenuRange(input2));
        assertTrue(InputUtils.isDigitInMenuRange(input3));
    }

}