package baseball.domain.exception;

public class BaseballNumberRangeException extends RuntimeException {
    private static final String ERROR_MESSAGE = "유효하지 않은 범위의 야구 번호 값입니다. (값 : %d)";

    public BaseballNumberRangeException(int baseballNumber) {
        super(String.format(ERROR_MESSAGE, baseballNumber));
    }
}
