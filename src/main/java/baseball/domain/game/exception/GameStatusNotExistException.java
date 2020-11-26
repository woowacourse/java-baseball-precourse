package baseball.domain.game.exception;

public final class GameStatusNotExistException extends RuntimeException {

    private static final String MESSAGE = "존재하지 않는 게임 상태 값입니다. (입력 값: '%s')";

    public GameStatusNotExistException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
