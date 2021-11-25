package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballStateTest {
    @DisplayName("ball이 n개, strike가 0개 인 경우 n볼이다.")
    @ParameterizedTest(name = "{index} -> ballCount {0}, strikeCount {1}인 경우 {2}이다.")
    @CsvSource({"1, 0, 1볼", "2, 0, 2볼", "3, 0, 3볼"})
    void getMessageBall(int ballCount, int strikeCount, String result) {
        // given
        BaseballState baseballState = new BaseballState(ballCount, strikeCount);

        // when
        String message = baseballState.getMessage();

        // then
        assertThat(message).isEqualTo(result);
    }

    @DisplayName("ball이 0개, strike가 n개 인 경우 n스트라이크이다.")
    @ParameterizedTest(name = "{index} -> ballCount {0}, strikeCount {1}인 경우 {2}이다.")
    @CsvSource({"0, 1, 1스트라이크", "0, 2, 2스트라이크", "0, 3, 3스트라이크"})
    void getMessageStrike(int ballCount, int strikeCount, String result) {
        // given
        BaseballState baseballState = new BaseballState(ballCount, strikeCount);

        // when
        String message = baseballState.getMessage();

        // then
        assertThat(message).isEqualTo(result);
    }

    @DisplayName("ball이 n개, strike가 m개 인 경우 n볼 m스트라이크이다.")
    @ParameterizedTest(name = "{index} -> ballCount {0}, strikeCount {1}인 경우 {2}이다.")
    @CsvSource({"1, 1, 1볼 1스트라이크", "2, 1, 2볼 1스트라이크"})
    void getMessageBallAndStrike(int ballCount, int strikeCount, String result) {
        // given
        BaseballState baseballState = new BaseballState(ballCount, strikeCount);

        // when
        String message = baseballState.getMessage();

        // then
        assertThat(message).isEqualTo(result);
    }

    @DisplayName("ball이 0개, strike가 0개 인 경우 낫싱이다.")
    @ParameterizedTest(name = "{index} -> ballCount {0}, strikeCount {1}인 경우 {2}이다.")
    @CsvSource({"0, 0, 낫싱"})
    void getMessageNotting(int ballCount, int strikeCount, String result) {
        // given
        BaseballState baseballState = new BaseballState(ballCount, strikeCount);

        // when
        String message = baseballState.getMessage();

        // then
        assertThat(message).isEqualTo(result);
    }

    @DisplayName("3스트라이크이면 성공이다.")
    @Test
    void isSuccessThenTrue() {

        // given
        BaseballState baseballState = new BaseballState(0, 3);

        // when
        boolean success = baseballState.isSuccess();

        // then
        assertThat(success).isTrue();
    }

    @DisplayName("1볼 1스트라이크이면 실패이다.")
    @Test
    void isSuccessThenFalse() {

        // given
        BaseballState baseballState = new BaseballState(1, 1);

        // when
        boolean success = baseballState.isSuccess();

        // then
        assertThat(success).isFalse();
    }
}