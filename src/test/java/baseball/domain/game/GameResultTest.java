package baseball.domain.game;

import baseball.domain.exception.InvalidGameResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class GameResultTest {

    @DisplayName("볼과 스트라이크 값의 범위가 0-3이 아니거나 두 값의 합이 3을 초과하면, GameResult 객체 생성 실패")
    @ParameterizedTest
    @CsvSource({"-1, 1", "1, 4", "2, 2", "1, 3"})
    public void GameResult_범위_오류_예외_발생(int ballCounts, int strikeCounts) {
        assertThatCode(() -> {
            new GameResult(ballCounts, strikeCounts);
        }).isInstanceOf(InvalidGameResultException.class);
    }

    @DisplayName("볼이나 스트라이크 모두 1개도 못 맞춘 경우 isNothing은 true")
    @Test
    public void isNothing_0점일때_true() {
        GameResult gameResult = new GameResult(0, 0);
        assertThat(gameResult.isNothing()).isTrue();
    }

    @DisplayName("볼이나 스트라이크를 1개라도 맞춘 경우 isNothing은 false")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "2, 1"})
    public void isNothing__맞춘_것이_있으면_false(int ballCounts, int strikeCounts) {
        GameResult gameResult = new GameResult(ballCounts, strikeCounts);
        assertThat(gameResult.isNothing()).isFalse();
    }

    @DisplayName("볼이 0개이고, 스트라이크가 1개 이상이면 isOnlyStrike는 true")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void isOnlyStrike_스트라이크_점수만_존재하면_true(int strikeCounts) {
        GameResult gameResult = new GameResult(0, strikeCounts);
        assertThat(gameResult.isOnlyStrike()).isTrue();
    }

    @DisplayName("볼이 1개 이상 존재하거나 스트라이크가 0개인 경우, isOnlyStrike는 false")
    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "1, 0"})
    public void isOnlyStrike_예외값_false(int ballCounts, int strikeCounts) {
        GameResult gameResult = new GameResult(ballCounts, strikeCounts);
        assertThat(gameResult.isOnlyStrike()).isFalse();
    }

    @DisplayName("스트라이크가 0개이고, 볼이 1개 이상이면 isOnlyBall은 true")
    @Test
    public void isOnlyBall_스트라이크_0개_볼_1개_이상_True() {
        GameResult gameResult = new GameResult(1, 0);
        assertThat(gameResult.isOnlyBall()).isTrue();
    }

    @DisplayName("스트라이크가 1개 이상 존재하거나 볼이 0개인 경우, isOnlyBall은 false")
    @ParameterizedTest
    @CsvSource({"0, 0", "0, 1", "1, 1"})
    public void isOnlyBall_예외값_false(int ballCounts, int strikeCounts) {
        GameResult gameResult = new GameResult(ballCounts, strikeCounts);
        assertThat(gameResult.isOnlyBall()).isFalse();
    }

    @DisplayName("볼 개수 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 볼_개수를_정상_반환한다(int ballCounts) {
        GameResult gameResult = new GameResult(ballCounts, 0);
        assertThat(gameResult.getBallCounts()).isEqualTo(ballCounts);
    }

    @DisplayName("스트라이크 개수 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 스트라이크_개수를_정상_반환한다(int strikeCounts) {
        GameResult gameResult = new GameResult(0, strikeCounts);
        assertThat(gameResult.getStrikeCounts()).isEqualTo(strikeCounts);
    }

    @DisplayName("스트라이크가 3개면 isEndOfGame는 true")
    @Test
    public void isEndOfGame_스트라이크_3개_True() {
        GameResult gameResult = new GameResult(0, 3);
        assertThat(gameResult.isEndOfGame()).isTrue();
    }

    @DisplayName("스트라이크가 3개아 아니면 isEndOfGame는 false")
    @Test
    public void isEndOfGame_스트라이크_3개가_아니면_False() {
        GameResult gameResult = new GameResult(1, 2);
        assertThat(gameResult.isEndOfGame()).isFalse();
    }
}
