package baseball.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 각자리_범위_테스트() {

        String positiveNumber = "123";
        String includeZero = "905";
        String includeChar = "a12";

        assertDoesNotThrow(() -> InputValidator.isInRange(positiveNumber,
                RandomDigitsGenerator.RANDOM_DIGIT_MIN, RandomDigitsGenerator.RANDOM_DIGIT_MAX));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isInRange(includeZero,
                RandomDigitsGenerator.RANDOM_DIGIT_MIN, RandomDigitsGenerator.RANDOM_DIGIT_MAX));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isInRange(includeChar,
                RandomDigitsGenerator.RANDOM_DIGIT_MIN, RandomDigitsGenerator.RANDOM_DIGIT_MAX));
    }

    @Test
    void 입력값_길이_테스트() {
        String digit = "3";
        String threeDigits = "486";
        String lessThanThreeDigits = "23";
        String moreThanThreeDigits = "3657";

        assertDoesNotThrow(() -> InputValidator.isSameLength(digit, InputValidator.GAME_MENU_LENGTH));
        assertDoesNotThrow(() -> InputValidator.isSameLength(threeDigits, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isSameLength(lessThanThreeDigits, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isSameLength(moreThanThreeDigits, RandomDigitsGenerator.RANDOM_DIGIT_COUNT));
    }

    @Test
    void 서로_다른_수_테스트() {
        String uniqueDigits = "123";
        String duplicateDigits = "131";

        assertDoesNotThrow(() -> InputValidator.isUniqueDigits(uniqueDigits));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isUniqueDigits(duplicateDigits));
    }

    @Test
    void 게임입력_검증_적합_테스트() {
        String properInput = "457";
        String improperInput = "161r";

        assertDoesNotThrow(() -> InputValidator.validateGameDigits(properInput));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateGameDigits(improperInput));
    }

    @Test
    void 메뉴입력_검증_적합_테스트() {
        String properInput = "1";
        String improperInput = "5";

        assertDoesNotThrow(() -> InputValidator.validateGameMenu(properInput));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateGameMenu(improperInput));

    }
}