package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BallPositionTest {

    @DisplayName("야구공 위치 생성")
    @Test
    void test1() {
        int position = 1;
        BaseBallPosition baseBallPosition = new BaseBallPosition(position);

        assertThat(baseBallPosition).isEqualTo(new BaseBallPosition(1));
    }

    @DisplayName("올바르지 않은 위치의 공 생성시")
    @ParameterizedTest
    @CsvSource(value = {"0", "4"})
    void test2(int invalidPosition) {
        assertThatThrownBy(() -> new BaseBallPosition(invalidPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidPosition + "는 올바른 위치가 아닙니다.");
    }
}
