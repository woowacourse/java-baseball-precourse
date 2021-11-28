package baseball.domain.number;

import baseball.exception.number.BaseBallNumberRangeException;
import java.util.Objects;

public class BaseBallNumber {

    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 9;

    private final int number;

    private BaseBallNumber(int number) {
        this.number = number;
    }

    public static BaseBallNumber from(int number) {
        checkNumberRange(number);
        return new BaseBallNumber(number);
    }

    private static void checkNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new BaseBallNumberRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseBallNumber that = (BaseBallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
