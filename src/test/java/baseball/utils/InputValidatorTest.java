package baseball.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 입력값_숫자_테스트() {

        String positiveNumber = "123";
        String negativeNumber = "-758";
        String includeZero = "905";
        String includeChar = "a12";

        assertDoesNotThrow(() -> InputValidator.validateDigit(positiveNumber));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateDigit(negativeNumber));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateDigit(includeZero));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateDigit(includeChar));
    }

    @Test
    void 입력값_길이_테스트() {
        String threeDigits = "486";
        String negativeThreeDigits = "-486";
        String lessThanThreeDigits = "23";
        String moreThanThreeDigits = "3657";

        assertDoesNotThrow(() -> InputValidator.validateLength(threeDigits));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateLength(negativeThreeDigits));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateLength(lessThanThreeDigits));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateLength(moreThanThreeDigits));
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

        assertDoesNotThrow(() -> InputValidator.validateGameDigits(properInput));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateGameDigits(improperInput));
    }
}