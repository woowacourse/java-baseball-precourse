package baseball.domain.number;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallNumbersTest {

    @Test
    @DisplayName("4개 이상의 수가 입력될 경우 Exception이 발생해야 한다.")
    void createExceptionByOutOfInputSize() {
        // given
        List<Integer> input = Arrays.asList(1, 2, 3, 4);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> BaseBallNumbers.createByIntegerNumbers(input))
            .withMessageMatching("3개 이상의 공이 입력될 수 없습니다.");
    }
}