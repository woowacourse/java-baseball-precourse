package baseball.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BaseballNumberValidatorTest {
    private static final String IS_NOT_THREE_DIGIT = "입력값은 세자리이어야 합니다.";
    private static final String CAN_NOT_CONTAIN_ZERO = "입력값은 0을 포합할 수 없습니다.";
    private static final String CAN_NOT_DUPLICATE = "입력값은 중복된 숫자를 포함할 수 없습니다.";

    @Test
    public void 올바른_입력값_들어올_경우_예외_발생하지_않음() {
        //given
        List<Integer> baseballNumber = Arrays.asList(1, 2, 3);

        //when & then
        assertDoesNotThrow(() -> BaseballNumberValidator.validateBaseballNumber(baseballNumber));
    }

    @Test
    public void 입력값이_세자리_수가_아니면_예외_발생() {
        //given
        List<Integer> baseballNumber = Arrays.asList(1, 2, 3, 4);

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumberValidator.validateBaseballNumber(baseballNumber))
                .withMessage(IS_NOT_THREE_DIGIT);
    }

    @Test
    public void 입력값에_0이_포함되어_있으면_예외_발생() {
        //given
        List<Integer> baseballNumber = Arrays.asList(0, 2, 3);

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumberValidator.validateBaseballNumber(baseballNumber))
                .withMessage(CAN_NOT_CONTAIN_ZERO);
    }

    @Test
    public void 입력값에_중복된_숫자가_있으면_예외_발생() {
        //given
        List<Integer> baseballNumber = Arrays.asList(1, 2, 2);

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumberValidator.validateBaseballNumber(baseballNumber))
                .withMessage(CAN_NOT_DUPLICATE);
    }
}