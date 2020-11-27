package baseball.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RestartCommandValidatorTest {
    private static final String RESTART = "1";
    private static final String TERMINATE = "2";
    private static final String PLEASE_INPUT_ONE_OR_TWO = "입력값은 1혹은 2 둘 중 하나이어야 합니다. ";


    @Test
    public void 입력값이_1과2를_제외한_값이면_예외_발생() {
        //given
        String restartCommand = "3";

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RestartCommandValidator.validateRestartCommand(restartCommand))
                .withMessage(PLEASE_INPUT_ONE_OR_TWO);
    }

    @Test
    public void 입력값이_1이면_예외_발생하지_않음() {
        //given
        String restartCommand = RESTART;

        //when & then
        assertDoesNotThrow(() -> RestartCommandValidator.validateRestartCommand(restartCommand));
    }

    @Test
    public void 입력값이_2이면_예외_발생하지_않음() {
        //given
        String restartCommand = TERMINATE;

        //when & then
        assertDoesNotThrow(() -> RestartCommandValidator.validateRestartCommand(restartCommand));
    }
}