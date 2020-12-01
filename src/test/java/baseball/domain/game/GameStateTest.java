package baseball.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class GameStateTest {

    @DisplayName("initiate하면 GameState는 KEEP_PLAYING Enum을 반환")
    @Test
    public void initiate_KEEP_PLAYING_반환() {
        GameState gameState = GameState.initiate();
        assertThat(gameState).isEqualTo(GameState.KEEP_PLAYING);
    }

    @DisplayName("gameStateNumber가 0이면 KEEP_PLAYING Enum 반환")
    @Test
    public void findGameState_0인경우_KEEP_PLAYING() {
        GameState gameState = GameState.findGameState(0);
        assertThat(gameState).isEqualTo(GameState.KEEP_PLAYING);
    }

    @DisplayName("gameStateNumber가 1이면 RESTART Enum 반환")
    @Test
    public void findGameState_1인경우_RESTART() {
        GameState gameState = GameState.findGameState(1);
        assertThat(gameState).isEqualTo(GameState.RESTART);
    }

    @DisplayName("gameStateNumber가 2이면 EXIT Enum 반환")
    @Test
    public void findGameState_2인경우_EXIT() {
        GameState gameState = GameState.findGameState(2);
        assertThat(gameState).isEqualTo(GameState.EXIT);
    }

    @DisplayName("없는 gameStateNumber인 경우 Enum 탐색 실패, 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    public void findGameState_예외값_예외발생(int gameStateNumber) {
        assertThatCode(() -> {
            GameState.findGameState(gameStateNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Exit enum의 경우 더이상 게임 플레이 진행 불가")
    @Test
    public void isAbleToPlay_Exit경우_False() {
        assertThat(GameState.EXIT.isAbleToPlay()).isFalse();
    }

    @DisplayName("KEEP_PLAYING 및 RESTART Enum들은 계속 게임 플레이 가능")
    @Test
    public void isAbleToPlay_그외_True() {
        assertThat(GameState.KEEP_PLAYING.isAbleToPlay()).isTrue();
        assertThat(GameState.RESTART.isAbleToPlay()).isTrue();
    }
}
