/**
 * 공 원시값을 나타내고 범위를 체크한다.
 */

package baseball;

public class BallNumber {
    private final static int MIN_BALL_NUMBER = 1;
    private final static int MAX_BALL_NUMBER = 9;
    private final static String OUT_OF_RANGE = "공번호는 1부터 9까지입니다.";

    private int number;

    public BallNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (MIN_BALL_NUMBER > number || MAX_BALL_NUMBER < number) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    public int getNumber() {
        return number;
    }

}
