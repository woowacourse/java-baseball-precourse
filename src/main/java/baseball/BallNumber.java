package baseball;

public class BallNumber {
    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_BALL_NUMBER = 9;
    private static final String OUT_OF_RANGE = "공번호는 1부터 9까지입니다.";

    private int number;

    public BallNumber(int number) {
        validateRange(number);
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    private void validateRange(int number) {
        if (MIN_BALL_NUMBER > number || MAX_BALL_NUMBER < number) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }



}
