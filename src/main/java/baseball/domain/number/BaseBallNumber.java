package baseball.domain.number;

import baseball.exception.number.BaseBallNumberRangeException;

public class BaseBallNumber {

    private final int number;

    private BaseBallNumber(int number) {
        this.number = number;
    }

    public static BaseBallNumber from(int number) {
        checkNumberRange(number);
        return new BaseBallNumber(number);
    }

    private static void checkNumberRange(int number) {
        if (number < 0 || number > 9) {
            throw new BaseBallNumberRangeException();
        }
    }
}
