package baseball;

public class Ball {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    private int number;

    public Ball(int number) {
        validateScope(number);
        this.number = number;
    }

    private void validateScope(int number) {
        if (1 > number || 9 < number) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number;
    }
}
