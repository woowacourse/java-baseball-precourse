package baseball.domain.game;

import baseball.domain.game.exception.GameStatusNotExistException;

public enum GameStatus {

    RUN(1),
    EXIT(2);

    private final int value;

    GameStatus(int value) {
        this.value = value;
    }

    public static GameStatus get(int value) {
        for (GameStatus status : values()) {
            if (status.value == value) {
                return status;
            }
        }

        throw new GameStatusNotExistException(value);
    }

    public int getValue() {
        return this.value;
    }
}
