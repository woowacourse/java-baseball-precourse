package baseball;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Balls {
    private final static String DUPLICATE_NUMBER = "입력값에 중복된 수가 있습니다.";
    private final static int NOT_FOUND = -1;

    private final List<BallNumber> balls;

    public Balls(List<BallNumber> balls) {
        validateDuplicate(balls);
        this.balls = balls;
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

    public List<BallNumber> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public int containAt(BallNumber ballNumber) {
        for (int index = 0; index < balls.size(); index++) {
            if(ballNumber.getNumber() == balls.get(index).getNumber()){
                return index;
            }
        }
        return NOT_FOUND;
    }

}
