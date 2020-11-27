package domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStateTest {

    @DisplayName("SignatureValue가 0이면 KEEP_PLAYING Enum 반환")
    @Test
    public void getGameState_0인경우_KEEP_PLAYING() {
        GameState gameState = GameState.findGameState(0);

        assertThat(gameState).isEqualTo(GameState.KEEP_PLAYING);
    }

    @DisplayName("SignatureValue가 1이면 RESTART Enum 반환")
    @Test
    public void getGameState_1인경우_RESTART() {
        GameState gameState = GameState.findGameState(1);

        assertThat(gameState).isEqualTo(GameState.RESTART);
    }

    @DisplayName("SignatureValue가 2이면 EXIT Enum 반환")
    @Test
    public void getGameState_2인경우_EXIT() {
        GameState gameState = GameState.findGameState(2);

        assertThat(gameState).isEqualTo(GameState.EXIT);
    }
}
