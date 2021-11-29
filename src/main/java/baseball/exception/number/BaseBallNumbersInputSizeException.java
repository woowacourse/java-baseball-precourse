package baseball.exception.number;

public class BaseBallNumbersInputSizeException extends IllegalArgumentException {

    private final static String BASEBALL_NUMBERS_INPUT_SIZE_ERROR_MESSAGE = "3개의 수가 입력되어야 합니다.";

    public BaseBallNumbersInputSizeException() {
        super(BASEBALL_NUMBERS_INPUT_SIZE_ERROR_MESSAGE);
    }
}
