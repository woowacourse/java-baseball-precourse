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

    @DisplayName("볼이나 스트라이크 모두 1개도 못 맞춘 경우 isNothing은 true를 반환")
    @Test
    public void isNothing_0점일때_true_반환() {
        gameResultMap.put("볼", 0);
        gameResultMap.put("스트라이크", 0);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.isNothing()).isTrue();
    }

    @DisplayName("볼이나 스트라이크를 1개라도 맞춘 경우 isNothing은 false를 반환")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "1, 1"})
    public void isNothing__맞춘_것이_있으면_false_반환(int ballCounts, int strikeCounts) {
        gameResultMap.put("볼", ballCounts);
        gameResultMap.put("스트라이크", strikeCounts);
        GameResult gameResult = new GameResult(gameResultMap);
        assertThat(gameResult.isNothing()).isFalse();
    }
}
