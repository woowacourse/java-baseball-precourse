package baseball.domain;

import static baseball.config.BaseballConfiguration.BALL_LENGTH;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Set;

public class BaseballGame {
    private Set<Integer> baseballNumbers;

    public BaseballGame() {
    }

    public void createBaseballNumbers() {
        baseballNumbers = new HashSet<>();
        while (baseballNumbers.size() < BALL_LENGTH) {
            baseballNumbers.add(RandomUtils.nextInt(1, 9));
        }
    }
}
