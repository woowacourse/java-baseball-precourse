package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private static final int VALID_NUMBER_SIZE = 3;
    private List<Integer> balls;

    public Balls(List<Integer> balls) {
        validateBallsSize(balls);
        validateOverlappedNumber(balls);
        validateIfNumberIsNotZero(balls);
        this.balls = new ArrayList<>(balls);
    }

    public int countStrike(List<Integer> inputBalls) {
        return (int) IntStream.range(0, inputBalls.size())
                .filter(i -> inputBalls.get(i) == balls.get(i))
                .count();
    }

    public int countBall(List<Integer> inputBalls) {
        return (int) IntStream.range(0, inputBalls.size())
                .filter(i -> inputBalls.get(i) != balls.get(i) && inputBalls.contains(balls.get(i)))
                .count();
    }

    private void validateBallsSize(List<Integer> balls) {
        if (balls.size() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException("3자리의 수만 입력해야 합니다.");
        }
    }

    private void validateOverlappedNumber(List<Integer> balls) {
        HashSet<Integer> ballsSet = new HashSet<>(balls);
        if (balls.size() != ballsSet.size()) {
            throw new IllegalArgumentException("세 자리의 숫자에서 각 자리의 숫자에 중복된 숫자가 포함되면 안 됩니다.");
        }
    }

    private void validateIfNumberIsNotZero(List<Integer> balls) {
        if (balls.contains(0)) {
            throw new IllegalArgumentException("숫자로 0을 입력하실 수 없습니다. 1 ~ 9의 숫자만 입력해야 합니다.");
        }
    }
}
