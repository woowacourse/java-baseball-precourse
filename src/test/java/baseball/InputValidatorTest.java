package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("유저의 정답 예측은 숫자로만 이루어진 길이가 3인 문자열이다.")
    @Test
    void validate_user_estimation_pass() {
        //given
        String userInput = "123";
        InputValidator inputValidator = new InputValidator();

        //when //then
        assertThatCode(() -> inputValidator.validateUserEstimation(userInput))
            .doesNotThrowAnyException();
    }


    @DisplayName("길이가 3이 아닌 유저 예측 인풋은 검증에 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234"})
    void validate_user_estimation_fail_length(String userInput) {
        //given
        InputValidator inputValidator = new InputValidator();

        //when //then
        assertThatThrownBy(() -> inputValidator.validateUserEstimation(userInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.INVALID_INPUT_LENGTH.getMessage());
    }

    @DisplayName("숫자가 아닌 문자를 포함한 유저 예측 인풋은 검증에 실패한다.")
    @Test
    void validate_user_estimation_fail_invalid_character() {
        //given
        String userInput = "12a";
        InputValidator inputValidator = new InputValidator();

        //when //then
        assertThatThrownBy(() -> inputValidator.validateUserEstimation(userInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.CONTAINS_INVALID_CHARACTER.getMessage());
    }
}
