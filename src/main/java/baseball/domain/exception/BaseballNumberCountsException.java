package baseball.domain.exception;

public class BaseballNumberCountsException extends RuntimeException {
    private static final String ERROR_MESSAGE = "유효하지 않은 중복 제외 야구 번호 개수입니다. (개수 : %d)";

    public BaseballNumberCountsException(int distinctCounts) {
        super(String.format(ERROR_MESSAGE, distinctCounts));
    }
}
