package baseball.domain;

import java.util.Objects;

public class BaseballNumber {
    public static final int MIN_BASEBALL_NUMBER = 1;
    public static final int MAX_BASEBALL_NUMBER = 9;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return baseballNumber == that.baseballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumber);
    }
}
