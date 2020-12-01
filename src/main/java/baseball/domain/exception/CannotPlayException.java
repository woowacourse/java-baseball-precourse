package baseball.domain.exception;

public class CannotPlayException extends RuntimeException {
    private static final String ERROR_MESSAGE = "더이상 게임을 진행할 수 없습니다.";

    public CannotPlayException() {
        super(ERROR_MESSAGE);
    }
}
