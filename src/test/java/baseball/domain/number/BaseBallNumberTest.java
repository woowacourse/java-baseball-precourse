package baseball.domain.number;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10, 25})
    @DisplayName("1~9 범위를 벗어난 수가 입력될 경우 Exception이 발생해야 한다.")
    void createExceptionByOutOfRange(int input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> BaseBallNumber.from(input))
            .withMessageMatching("1~9 사이의 값만 입력하여야 합니다.");
    }
}