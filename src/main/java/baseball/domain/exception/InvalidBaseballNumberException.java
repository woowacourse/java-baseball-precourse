package baseball.domain.exception;

public class InvalidBaseballNumberException extends RuntimeException {
    private static final String ERROR_MESSAGE = "유효하지 않은 야구 번호입니다. (%d)";

    public InvalidBaseballNumberException(int baseballNumber) {
        super(String.format(ERROR_MESSAGE, baseballNumber));
    }
}
