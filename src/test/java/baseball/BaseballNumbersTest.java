package baseball;

import static baseball.BaseballGame.MIN_NUMBER;
import static baseball.BaseballNumbers.MAX_PITCH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @Test
    void BaseballNumbers_CorrectForm_NoExceptionThrown() {
        List<Integer> correctFormOfList = new ArrayList<>();
        int currentNumber = MIN_NUMBER;
        while (correctFormOfList.size() != MAX_PITCH) {
            correctFormOfList.add(currentNumber);
            currentNumber++;
        }

        try {
           new BaseballNumbers(correctFormOfList);
        } catch (Exception e) {
            fail("This test should not throw any exception");
        }
    }

    @Test
    void BaseballNumbers_WrongSize_ExceptionThrown() {
        List<Integer> wrongFormOfList = new ArrayList<>();
        int currentNumber = MIN_NUMBER;
        while (wrongFormOfList.size() != MAX_PITCH + 1) {
            wrongFormOfList.add(currentNumber);
            currentNumber++;
        }

        try {
            new BaseballNumbers(wrongFormOfList);
            fail("This test should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("숫자는 " + MAX_PITCH + "개만 입력해야 합니다", e.getMessage());
        }
    }

    @Test
    void BaseballNumbers_DuplicatedItems_ExceptionThrown() {
        List<Integer> wrongFormOfList = new ArrayList<>();
        while (wrongFormOfList.size() != MAX_PITCH) {
            wrongFormOfList.add(MIN_NUMBER);
        }

        try {
            new BaseballNumbers(wrongFormOfList);
            fail("This test should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("배열 내에 중복된 숫자가 있으면 안 됩니다", e.getMessage());
        }
    }
}
