package baseball.exception.number;

public class BaseBallNumbersInputSizeException extends IllegalArgumentException {

    private final static String BASEBALL_NUMBERS_INPUT_SIZE_ERROR_MESSAGE = "3개 이상의 공이 입력될 수 없습니다.";

    public BaseBallNumbersInputSizeException() {
        super(BASEBALL_NUMBERS_INPUT_SIZE_ERROR_MESSAGE);
    }
}
