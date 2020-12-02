package domain;

import ui.Output;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final static int START_VALUE_IN_RANDOM_NUMBER_RANGE = 1;
    private final static int END_VALUE_IN_RANDOM_NUMBER_RANGE = 9;
    private final static int VALID_NUMBER_SIZE = 3;
    private final static int STRIKE_FULL_COUNT = 3;
    private Balls balls;
    private List<Ball> randomBalls = new ArrayList<>();

    public Computer() {
        this.balls = getRandomBalls();
    }

    public boolean isCorrectAnswer(List<Ball> inputBalls) {
        int ballCount = balls.countBall(inputBalls);
        int strikeCount = balls.countStrike(inputBalls);

        Output.printBallOrStrikeCount(strikeCount, ballCount);
        if (strikeCount == STRIKE_FULL_COUNT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private Balls getRandomBalls() {
        List<Integer> randomNumbers = new ArrayList<>();
        setRandomNumbers(randomNumbers);

        for (int i = 0; i < randomNumbers.size(); i++) {
            randomBalls.add(new Ball(randomNumbers.get(i)));
        }

        return new Balls(randomBalls);
    }

    private List<Integer> setRandomNumbers(List<Integer> storage) {
        int randomNumber = RandomUtils.nextInt(
                START_VALUE_IN_RANDOM_NUMBER_RANGE,
                END_VALUE_IN_RANDOM_NUMBER_RANGE);
        if (!storage.contains(randomNumber)) {
            storage.add(randomNumber);
        }
        if (storage.size() != VALID_NUMBER_SIZE) {
            setRandomNumbers(storage);
        }
        return storage;
    }
}