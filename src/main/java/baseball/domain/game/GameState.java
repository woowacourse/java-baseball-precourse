package baseball.domain.game;

import java.util.Arrays;

public enum GameState {
    KEEP_PLAYING(0),
    RESTART(1),
    EXIT(2);

    private final int signatureValue;

    private GameState(int signatureValue) {
        this.signatureValue = signatureValue;
    }

    public static GameState findGameState(int signatureValue) {
        return Arrays.stream(values())
                .filter(gameState -> gameState.signatureValue == signatureValue)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isAbleToPlay() {
        return this != EXIT;
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
