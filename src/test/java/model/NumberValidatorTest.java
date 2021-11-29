package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    @Test
    @DisplayName("정수가 아닌 값이 있으면 예외를 발생시킨다.")
    void evokeExceptionByNonInteger() {
        String[] wrongInputTokens = new String[]{"1", "?", "3"};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NumberValidator.getValidatedNumbers(wrongInputTokens))
                .withMessage("정수만 입력하셔야합니다.");
    }

    @Test
    @DisplayName("문자열 배열로 입력된 값을 정수 유효성 검사 후, 정수 타입의 List로 반환한다.")
    void getValidatedNumbers() {
        String[] inputTokens = new String[]{"1", "2", "3"};
        List<Integer> actual = NumberValidator.getValidatedNumbers(inputTokens);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertThat(actual).isEqualTo(expected);
    }
}
