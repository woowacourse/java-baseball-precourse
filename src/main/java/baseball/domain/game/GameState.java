package baseball.domain.game;

import java.util.Arrays;

public enum GameState {
    KEEP_PLAYING(0),
    RESTART(1),
    EXIT(2);

    private final int gameStateNumber;

    private GameState(int gameStateNumber) {
        this.gameStateNumber = gameStateNumber;
    }

    public static GameState initiate() {
        return GameState.KEEP_PLAYING;
    }

    public static GameState findGameState(int gameStateNumber) {
        return Arrays.stream(values())
                .filter(gameState -> gameState.isMatch(gameStateNumber))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isMatch(int gameStateNumber) {
        return this.gameStateNumber == gameStateNumber;
    }

    public boolean isAbleToPlay() {
        return this != EXIT;
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
