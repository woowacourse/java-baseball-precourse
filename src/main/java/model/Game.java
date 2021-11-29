package model;

import java.util.List;

import model.ball.Baseballs;
import util.RandomNumbersGenerator;

public class Game {
    private final Baseballs computerBalls;
    private BallCount ballCount;
    private boolean isNotOver;

    public Game() {
        List<Integer> randomThreeNumbers = generateThreeRandomNumbers();
        computerBalls = new Baseballs(randomThreeNumbers);
        isNotOver = true;
    }

    List<Integer> generateThreeRandomNumbers() {
        int minValue = 1;
        int maxValue = 9;
        int countOfNumbers = 3;
        return RandomNumbersGenerator.generate(minValue, maxValue, countOfNumbers);
    }

    public boolean isNotOver() {
        return isNotOver;
    }

    public void tryOnce(final List<Integer> inputNumbers) {
        Baseballs userBalls = new Baseballs(inputNumbers);
        ballCount = new BallCount(computerBalls.compare(userBalls));
        isNotOver = !ballCount.isThreeStrike();
    }

    public BallCount getResult() {
        return ballCount;
    }
}