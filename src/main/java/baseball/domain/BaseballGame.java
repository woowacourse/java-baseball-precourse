package baseball.domain;

import static baseball.config.BaseballConfiguration.BALL_LENGTH;

import utils.RandomUtils;

import java.util.*;

public class BaseballGame {
    private List<Integer> baseballNumbers;
    private int ball;
    private int strike;
    private boolean gameStatus;

    public BaseballGame() {
        createBaseballNumbers();
    }

    private void createBaseballNumbers() {
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < BALL_LENGTH) {
            set.add(RandomUtils.nextInt(1, 9));
        }
        baseballNumbers = new ArrayList<>(set);
    }

    public void compareBaseBallNumbers(List<Integer> playerBaseballNumbers) {
        initScore();
        countScore(playerBaseballNumbers);
        checkGameStatus();
        printScore();
    }

    private void initScore() {
        ball = 0;
        strike = 0;
    }

    private void countScore(List<Integer> playerBaseballNumbers) {
        for (int i = 0; i < baseballNumbers.size(); i++) {
            if (isStrike(playerBaseballNumbers, i)) {
                strike++;
            } else if (isBall(playerBaseballNumbers, i)) {
                ball++;
            }
        }
    }

    private boolean isStrike(List<Integer> playerBaseballNumbers, int index) {
        return baseballNumbers.get(index).equals(playerBaseballNumbers.get(index));
    }

    private boolean isBall(List<Integer> playerBaseballNumbers, int index) {
        return baseballNumbers.contains(playerBaseballNumbers.get(index));
    }

    private void checkGameStatus() {
        if (strike == 3) {
            gameStatus = false;
        }
    }

    private void printScore() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
