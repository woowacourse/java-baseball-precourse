package baseball;

import static baseball.Constants.GAME_MAX_BASEBALL_PITCH;
import static baseball.Constants.GAME_MIN_BASEBALL_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @Test
    void BaseballNumbers_CorrectForm_NoExceptionThrown() {
        final int[] correctFormOfArray = new int[GAME_MAX_BASEBALL_PITCH];
        int currentNumber = GAME_MIN_BASEBALL_NUMBER;
        for (int index = 0; index < correctFormOfArray.length; index++) {
            correctFormOfArray[index] = currentNumber++;
        }

        try {
            new BaseballNumbers(correctFormOfArray);
        } catch (Exception e) {
            fail("This test should not throw any exception");
        }
    }

    @Test
    void BaseballNumbers_WrongSize_ExceptionThrown() {
        final int[] wrongFormOfArray = new int[GAME_MAX_BASEBALL_PITCH + 1];
        int currentNumber = GAME_MIN_BASEBALL_NUMBER;
        for (int index = 0; index < wrongFormOfArray.length; index++) {
            wrongFormOfArray[index] = currentNumber++;
        }

        try {
            new BaseballNumbers(wrongFormOfArray);
            fail("This test should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessages.ARRAY_INVALID_LENGTH.getMessage(), e.getMessage());
        }
    }

    @Test
    void BaseballNumbers_DuplicatedItems_ExceptionThrown() {
        final int[] wrongFormOfArray = new int[GAME_MAX_BASEBALL_PITCH];
        Arrays.fill(wrongFormOfArray, GAME_MIN_BASEBALL_NUMBER);

        try {
            new BaseballNumbers(wrongFormOfArray);
            fail("This test should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessages.ARRAY_ITEM_DUPLICATED.getMessage(), e.getMessage());
        }
    }

    @Test
    void BaseballNumbers_ItemOutOfRange_ExceptionThrown() {
        final int[] wrongFormOfArray = new int[GAME_MAX_BASEBALL_PITCH];
        int currentNumber = GAME_MIN_BASEBALL_NUMBER - 1;
        for (int index = 0; index < wrongFormOfArray.length; index++) {
            wrongFormOfArray[index] = currentNumber++;
        }

        try {
            new BaseballNumbers(wrongFormOfArray);
            fail("This test should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessages.ARRAY_ITEM_OUT_OF_RANGE.getMessage(), e.getMessage());
        }
    }
}
