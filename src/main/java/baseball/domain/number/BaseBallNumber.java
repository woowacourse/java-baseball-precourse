package baseball.domain.number;

import baseball.exception.number.BaseBallNumberRangeException;

public class BaseBallNumber {

    public final static int MIN_NUMBER = 0;
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
}
