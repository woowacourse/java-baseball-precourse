package baseball.domain.number;

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
            throw new IllegalArgumentException("0~9 사이의 값만 입력하여야 합니다.");
        }
    }

}
