package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력값 길이가 3이 아니면 예외를 던진다.")
    @Test
    void validateLengthTest() {
        InputValidator validator = new InputValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            validator.validateGameNumberInput("4232")
        );
    }

    @DisplayName("입력값이 숫자가 아니면 예외를 던진다.")
    @Test
    void validateStringIsNumericTest() {
        InputValidator validator = new InputValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            validator.validateGameNumberInput("abc")
        );
    }

    @DisplayName("입력값이 0을 포함하면 예외를 던진다.")
    @Test
    void validateStringContainsZeroTest() {
        InputValidator validator = new InputValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            validator.validateGameNumberInput("403")
        );
    }

    @DisplayName("입력값이 0 또는 1이 아닌 경우 예외를 던진다.")
    @Test
    void validateRestartGameInputTest() {
        InputValidator validator = new InputValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            validator.validateGameNumberInput("3")
        );
    }

}