package baseball.utils;

import baseball.BaseballGameSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 입력값_범위_테스트() {

        String positiveNumber = "123";
        String negativeNumber = "-758";
        String includeZero = "905";
        String includeChar = "a12";

        assertDoesNotThrow(() -> InputValidator.validateGameDigitInRange(positiveNumber, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateGameDigitInRange(negativeNumber, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateGameDigitInRange(includeZero, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateGameDigitInRange(includeChar, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
    }

    @Test
    void 입력값_길이_테스트() {
        String digit = "3";
        String threeDigits = "486";
        String negativeThreeDigits = "-486";
        String lessThanThreeDigits = "23";
        String moreThanThreeDigits = "3657";

        assertDoesNotThrow(() -> InputValidator.validateLength(digit, BaseballGameSystem.GAME_MENU_LENGTH));
        assertDoesNotThrow(() -> InputValidator.validateLength(threeDigits, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateLength(negativeThreeDigits, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateLength(lessThanThreeDigits, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateLength(moreThanThreeDigits, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
    }

    @Test
    void 서로_다른_수_테스트() {
        String uniqueDigits = "123";
        String duplicateDigits = "131";

        assertDoesNotThrow(() -> InputValidator.validateUniqueDigits(uniqueDigits));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueDigits(duplicateDigits));
    }

    @Test
    void 모든_검증_적합_테스트() {
        String properInput = "457";
        String improperInput = "161r";
        String properGameMenuInput = "1";
        String improperGameMenuInput = "5";

        assertDoesNotThrow(() -> InputValidator.validateGameDigits(properInput));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateGameDigits(improperInput));
        assertDoesNotThrow(() -> InputValidator.validateGameMenu(properGameMenuInput));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateGameMenu(improperGameMenuInput));
    }
}