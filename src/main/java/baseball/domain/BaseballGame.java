package baseball.domain;

import static baseball.config.BaseballConfiguration.*;
import static baseball.domain.Status.*;

import utils.RandomUtils;

import java.util.*;

public class BaseballGame {
    private List<Integer> baseballNumbers;
    private Score score;
    private Status status;

    public BaseballGame() {
        createBaseballNumbers();
        status = EXECUTION;
    }

    private void createBaseballNumbers() {
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < BALL_LENGTH) {
            set.add(RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE));
        }
        baseballNumbers = new ArrayList<>(set);
    }

    public void compareBaseBallNumbers(List<Integer> playerBaseballNumbers) {
        initScore();
        countScore(playerBaseballNumbers);
        printScore();
        checkGameStatus();
    }

    private void initScore() {
        score = new Score();
    }

    private void countScore(List<Integer> playerBaseballNumbers) {
        for (int i = 0; i < baseballNumbers.size(); i++) {
            if (isStrike(playerBaseballNumbers, i)) {
                score.increaseStrikeCount();
            } else if (isBall(playerBaseballNumbers, i)) {
                score.increaseBallCount();
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
        if (score.isFullStrike()) {
            status = TERMINATION;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private void printScore() {
        if (score.isZeroBall() && score.isZeroStrike()) {
            System.out.println("낫싱");
        } else if (score.isZeroStrike()) {
            System.out.println(score.getBall() + "볼");
        } else if (score.isZeroBall()) {
            System.out.println(score.getStrike() + "스트라이크");
        } else {
            System.out.println(score.getBall() + "볼 " + score.getStrike() + "스트라이크");
        }
    }

    public boolean isExecution() {
        if (status == EXECUTION) {
            return true;
        }
        return false;
    }
}
