package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.domain.validator.NumbersValidator;
import baseball.domain.validator.Validator;

public class NumbersValidatorTest {

    private Validator validator;

    @BeforeEach
    public void initValidator() {
        validator = new NumbersValidator();
    }

    @Test
    @DisplayName("입력 값이 null일 경우 IllegalArgumentException 발생")
    public void inputNullValidationTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(null))
                .withMessage(Validator.INPUT_NULL_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 값을 입력하였을 경우 IllegalArgumentException 발생")
    public void inputEmptyStringTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(input))
                .withMessage(Validator.INPUT_EMPTY_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12"})
    @DisplayName("입력 값이 정규표현식과 맞지 않을 경우 IllegalArgumentException 발생")
    public void inputInvalidValueTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(input))
                .withMessage(Validator.INVALID_VALUE_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"122", "233"})
    @DisplayName("입력 값이 중복 숫자를 포함할 경우 IllegalArgumentException 발생")
    public void inputDuplicateNumberTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(input))
                .withMessage(NumbersValidator.DUPLICATE_NUMBER_MESSAGE);
    }
}
