package baseball;

public class Ball {

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
}
