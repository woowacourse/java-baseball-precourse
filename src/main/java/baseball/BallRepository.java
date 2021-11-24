package baseball;

import java.util.ArrayList;
import java.util.List;

public class BallRepository {
    List<Ball> balls = new ArrayList<>();

    public BallRepository(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            if (validationNumber(input.get(i))) {
                balls.add(new Ball(i, input.get(i)));
            }
        }
    }

    private boolean validationNumber(int number) {
        if (number >= 1 && number <= 9) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
