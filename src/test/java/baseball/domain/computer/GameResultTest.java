package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    @DisplayName("strike와 ball 합이 3 이상인 경우 exception이 발생해야 한다.")
    void createExceptionByCountSumIsOverThree() {
        // given
        int strikeCount = 2;
        int ballCount = 2;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> GameResult.from(strikeCount, ballCount))
            .withMessageMatching("Strike와 Ball의 갯수는 3개를 넘을 수 없습니다.");
    }
}