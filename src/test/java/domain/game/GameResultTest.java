package domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class GameResultTest {

    private Map<String, Integer> gameResultMap;

    @BeforeEach
    public void setup() {
        gameResultMap = new HashMap<>();
    }

    @DisplayName("게임 결과(볼, 스트라이크)가 저장된 Map을 파라미터로 받아, GameResult 객체를 정상 생성함")
    @Test
    public void GameResult_객체_생성_정상() {
        gameResultMap.put("볼", 1);
        gameResultMap.put("스트라이크", 0);
        assertThatCode(() -> {
            new GameResult(gameResultMap);
        }).doesNotThrowAnyException();
    }

    @DisplayName("GameResult 객체 생성 시, 게임 결과(볼, 스트라이크) key가 하나라도 없는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"볼", "스트라이크", "wrongKey"})
    public void GameReuslt_객체_생성_실패_KEY_오류(String key) {
        gameResultMap.put(key, 1);
        assertThatCode(() -> {
            new GameResult(gameResultMap);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("볼이나 스트라이크 모두 1개도 못 맞춘 경우 isNothing은 true")
    @Test
    public void isNothing_0점일때_true_반환() {
        gameResultMap.put("볼", 0);
        gameResultMap.put("스트라이크", 0);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.isNothing()).isTrue();
    }

    @DisplayName("볼이나 스트라이크를 1개라도 맞춘 경우 isNothing은 false")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "2, 1"})
    public void isNothing__맞춘_것이_있으면_false_반환(int ballCounts, int strikeCounts) {
        gameResultMap.put("볼", ballCounts);
        gameResultMap.put("스트라이크", strikeCounts);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.isNothing()).isFalse();
    }

    @DisplayName("볼이 0개이고, 스트라이크가 1개 이상이면 isOnlyStrike는 true")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 스트라이크_점수만_존재하면_isOnlyStrike는_true_반환(int strikeCounts) {
        gameResultMap.put("볼", 0);
        gameResultMap.put("스트라이크", strikeCounts);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.isOnlyStrike()).isTrue();
    }

    @DisplayName("볼이 1개 이상 존재하거나 스트라이크가 0개인 경우")
    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "1, 0"})
    public void isOnlyStrike_예외값_False반환(int ballCounts, int strikeCounts) {
        gameResultMap.put("볼", ballCounts);
        gameResultMap.put("스트라이크", strikeCounts);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.isOnlyStrike()).isFalse();
    }

    @DisplayName("스트라이크가 0개이고, 볼이 1개 이상이면 isOnlyBall은 true")
    @Test
    public void isOnlyBall_스트라이크_0개_볼_1개_이상_True() {
        gameResultMap.put("볼", 1);
        gameResultMap.put("스트라이크", 0);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.isOnlyBall()).isTrue();
    }

    @DisplayName("스트라이크가 1개 이상 존재하거나 볼이 0개인 경우")
    @ParameterizedTest
    @CsvSource({"0, 0", "0, 1", "1, 1"})
    public void isOnlyBall_예외값_False반환(int ballCounts, int strikeCounts) {
        gameResultMap.put("볼", ballCounts);
        gameResultMap.put("스트라이크", strikeCounts);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.isOnlyBall()).isFalse();
    }

    @DisplayName("볼 개수 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 볼_개수를_정상_반환한다(int ballCounts) {
        gameResultMap.put("볼", ballCounts);
        gameResultMap.put("스트라이크", 0);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.getBallCounts()).isEqualTo(ballCounts);
    }

    @DisplayName("스트라이크 개수 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 스트라이크_개수를_정상_반환한다(int strikeCounts) {
        gameResultMap.put("볼", 0);
        gameResultMap.put("스트라이크", strikeCounts);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.getStrikeCounts()).isEqualTo(strikeCounts);
    }
}
