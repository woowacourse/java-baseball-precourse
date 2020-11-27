package baseball.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PositiveIntegerValidatorTest {
    private static final String IS_NOT_NUMERIC = "입력값은 숫자이어야 합니다.";
    private static final String IS_NOT_POSITIVE = "입력값은 양수이어야 합니다.";

    @Test
    public void 양의_정수_입력시_예외_발생하지_않음() {
        //given
        String positiveInteger = "123";

        //when & then
        assertDoesNotThrow(() -> PositiveIntegerValidator.validatePositiveInteger(positiveInteger));
    }

    @Test
    public void 정수입력_아닐_시_예외_발생() {
        //given
        String notNumeric = "한글입력";

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> PositiveIntegerValidator.validatePositiveInteger(notNumeric))
                .withMessage(IS_NOT_NUMERIC);
    }

    @Test
    public void 음수입력_시_예외_발생() {
        //given
        String negative = "-12";

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> PositiveIntegerValidator.validatePositiveInteger(negative))
                .withMessage(IS_NOT_POSITIVE);
    }
}