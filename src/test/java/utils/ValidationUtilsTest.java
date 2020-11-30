package utils;

import baseball.model.ParameterSet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationUtilsTest {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;

    private static final String RESTART = "1";
    private static final String END = "2";

    @Test
    public void validateInput() {
        String userInput = "123";
        ParameterSet parameterSet =
                new ParameterSet(NUMBER_OF_DIGITS, MIN_DIGIT, MAX_DIGIT);

        String validInput =
                ValidationUtils.validateInputInProgress(userInput, parameterSet);

        assertThat(userInput).isEqualTo(validInput);
    }

    @Test
    public void validateInput_hasDifferentNumberOfDigits() {
        String userInput = "1234";
        ParameterSet parameterSet =
                new ParameterSet(NUMBER_OF_DIGITS, MIN_DIGIT, MAX_DIGIT);

        assertThrows(IllegalArgumentException.class,
                () -> ValidationUtils.validateInputInProgress(
                        userInput,
                        parameterSet));
    }

    @Test
    public void validateInput_isNotDigits() {
        String userInput = "a12";
        ParameterSet parameterSet =
                new ParameterSet(NUMBER_OF_DIGITS, MIN_DIGIT, MAX_DIGIT);

        assertThrows(IllegalArgumentException.class,
                () -> ValidationUtils.validateInputInProgress(
                        userInput,
                        parameterSet));
    }

    @Test
    public void validateInput_hasDuplicateDigits() {
        String userInput = "111";
        ParameterSet parameterSet =
                new ParameterSet(NUMBER_OF_DIGITS, MIN_DIGIT, MAX_DIGIT);

        assertThrows(IllegalArgumentException.class,
                () -> ValidationUtils.validateInputInProgress(
                        userInput,
                        parameterSet));
    }

    @Test
    public void validateInputAfterEnd() {
        String userInput = "1";

        String validInput =
                ValidationUtils.validateInputAfterEnd(userInput, RESTART, END);

        assertThat(userInput).isEqualTo(validInput);
    }

    @Test
    public void validateInputAfterEnd_except() {
        String userInput = "3";

        assertThrows(IllegalArgumentException.class,
                () -> ValidationUtils.validateInputAfterEnd(
                        userInput,
                        RESTART,
                        END));
    }
}
