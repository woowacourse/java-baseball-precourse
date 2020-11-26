package domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatCode;

class GameResultTest {

    @DisplayName("게임 결과(ball, strike)가 저장된 Map을 파라미터로 받아, GameResult 객체를 정상 생성함")
    @Test
    public void GameResult_객체_생성_정상() {
        Map<String, Integer> gameResult = new HashMap<>();
        gameResult.put("ball", 1);
        gameResult.put("strike", 0);
        assertThatCode(() -> {
            new GameResult(gameResult);
        }).doesNotThrowAnyException();
    }

    @DisplayName("GameResult 객체 생성 시, 게임 결과(ball, strike) key가 하나라도 없는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"ball", "strike", "wrongKey"})
    public void GameReuslt_객체_생성_실패_KEY_오류(String key) {
        Map<String, Integer> gameResult = new HashMap<>();
        gameResult.put(key, 1);
        assertThatCode(() -> {
            new GameResult(gameResult);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
