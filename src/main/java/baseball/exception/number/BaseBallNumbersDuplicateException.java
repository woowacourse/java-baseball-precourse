package baseball.exception.number;

public class BaseBallNumbersDuplicateException extends IllegalArgumentException {

    private final static String BASEBALL_NUMBERS_DUPLICATE_INPUT_ERROR_MESSAGE = "중복된 공이 입력될 수 없습니다.";

    public BaseBallNumbersDuplicateException() {
        super(BASEBALL_NUMBERS_DUPLICATE_INPUT_ERROR_MESSAGE);
    }
}
