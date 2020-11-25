package baseball.domain;

public class BaseballNumber {
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;
    private static final String INPUT_BASEBALL_NUMBER_RANGE_ERROR_MESSAGE = "1 ~ 9 까지의 숫자만 입력해주세요! ";

    private final int baseballNumber;

    public BaseballNumber(int baseballNumber) {
        validateBaseballNumber(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    private void validateBaseballNumber(int baseballNumber) {
        if (baseballNumber < MIN_BASEBALL_NUMBER || baseballNumber > MAX_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(INPUT_BASEBALL_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
