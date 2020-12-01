package baseball.domain.exception;

public class CannotFindGameStateException extends RuntimeException {
    private static final String ERROR_MESSAGE = "값과 일치하는 게임 상태를 찾을 수 없습니다. (값 : %d)";

    public CannotFindGameStateException(int gameStateNumber) {
        super(String.format(ERROR_MESSAGE, gameStateNumber));
    }
}
