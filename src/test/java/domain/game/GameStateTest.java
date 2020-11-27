package domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class GameStateTest {

    @DisplayName("SignatureValue가 0이면 KEEP_PLAYING Enum 반환")
    @Test
    public void findGameState_0인경우_KEEP_PLAYING() {
        GameState gameState = GameState.findGameState(0);
        assertThat(gameState).isEqualTo(GameState.KEEP_PLAYING);
    }

    @DisplayName("SignatureValue가 1이면 RESTART Enum 반환")
    @Test
    public void findGameState_1인경우_RESTART() {
        GameState gameState = GameState.findGameState(1);
        assertThat(gameState).isEqualTo(GameState.RESTART);
    }

    @DisplayName("SignatureValue가 2이면 EXIT Enum 반환")
    @Test
    public void findGameState_2인경우_EXIT() {
        GameState gameState = GameState.findGameState(2);
        assertThat(gameState).isEqualTo(GameState.EXIT);
    }

    @DisplayName("없는 SignatureValue인 경우 Enum 탐색 실패, 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    public void findGameState_예외값_예외발생(int signatureValue) {
        assertThatCode(() -> {
            GameState.findGameState(signatureValue);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
