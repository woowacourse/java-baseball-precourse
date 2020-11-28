package baseball;

import java.util.List;

public class Baseballs {
    public static final int BALLS_CONTAINER_SIZE = 3;

    private final List<Integer> balls;

    public Baseballs(List<Integer> balls) {
        this.balls = balls;
    }

    public List<Integer> getBalls() {
        return balls;
    }

    private void validate(List<Integer> balls) {
        validateSize(balls);
        validateNumerical(balls);
        validateNoZero(balls);
        validateNoDuplicate(balls);
    }

    private void validateSize(List<Integer> balls) {

    }

    private void validateNumerical(List<Integer> balls) {

    }

    private void validateNoZero(List<Integer> balls) {

    }

    private void validateNoDuplicate(List<Integer> balls) {

    }
}
