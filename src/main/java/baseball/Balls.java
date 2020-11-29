package baseball;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Balls {
    private final static String DUPLICATE_NUMBER = "입력값에 중복된 수가 있습니다.";

    private final List<BallNumber> balls;

    public Balls(List<BallNumber> balls) {
        validateDuplicate(balls);
        this.balls = balls;
    }

    public List<Integer> getBalls() {
        return balls.stream()
            .map(ballNumber -> ballNumber.getNumber())
            .collect(Collectors.toList());
    }

    private void validateDuplicate(List<BallNumber> balls) {
        if (isDuplicated(balls)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    private boolean isDuplicated(List<BallNumber> balls) {
        return balls.stream()
            .map(BallNumber::getNumber)
            .distinct()
            .count() != balls.size();
    }




}
