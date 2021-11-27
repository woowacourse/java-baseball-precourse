package baseball.exception.number;

public class BaseBallNumberRangeException extends IllegalArgumentException {

    private final static String BASEBALL_NUMBER_RANGE_ERROR_MESSAGE = "0~9 사이의 값만 입력하여야 합니다.";

    public BaseBallNumberRangeException() {
        super(BASEBALL_NUMBER_RANGE_ERROR_MESSAGE);
    }
}
