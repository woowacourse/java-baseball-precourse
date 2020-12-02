package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private static final int VALID_NUMBER_SIZE = 3;
    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateBallsSize(balls);
        validateOverlappedNumber(balls);
        this.balls = new ArrayList<>(balls);
    }

    public int countStrike(List<Ball> inputBalls) {
        return (int) IntStream.range(0, inputBalls.size())
                .filter(i -> inputBalls.get(i).getBall() == balls.get(i).getBall())
                .count();
    }

    public int countBall(List<Ball> inputBalls) {
        return (int) IntStream.range(0, inputBalls.size())
                .filter(i -> inputBalls.get(i).getBall() != balls.get(i).getBall()
                        && toIntegerList(inputBalls).contains(balls.get(i).getBall()))
                .count();
    }

    public List<Integer> toIntegerList(List<Ball> inputBalls) {
        List<Integer> balls = new ArrayList<>();
        for (int i = 0; i < inputBalls.size(); i++) {
            balls.add(inputBalls.get(i).getBall());
        }
        return balls;
    }

    private void validateBallsSize(List<Ball> balls) {
        if (balls.size() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException("3자리의 수만 입력해야 합니다.");
        }
    }

    private void validateOverlappedNumber(List<Ball> balls) {
        HashSet<Ball> ballsSet = new HashSet<>(balls);
        if (balls.size() != ballsSet.size()) {
            throw new IllegalArgumentException("세 자리의 숫자에서 각 자리의 숫자에 중복된 숫자가 포함되면 안 됩니다.");
        }
    }
}
