package baseball.domain.computer;

import java.util.Arrays;

public enum GameState {

    RUNNING(0),
    RESTART(1),
    END(2),
    ;

    private final int command;

    GameState(int command) {
        this.command = command;
    }

    public static GameState init() {
        return GameState.RUNNING;
    }

    public static GameState createByCommand(int inputCommand) {
        return Arrays.stream(values())
            .filter(gameState -> gameState.command == inputCommand)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 command 입니다."));
    }

    public boolean isEndGame() {
        return this == END;
    }

    public boolean isRestartGame() {
        return this == RESTART;
    }
}
