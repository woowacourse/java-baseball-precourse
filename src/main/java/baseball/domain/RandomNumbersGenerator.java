package baseball.domain;

import baseball.BaseballGame;
import utils.RandomUtils;

public class RandomNumbersGenerator implements NumbersGenerator {

    public static final int LOWER_BOUND = 0;

    public static final int UPPER_BOUND = 10;

    @Override
    public String generateNumbers() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < BaseballGame.BALLS_LENGTH; i++) {
            stringBuilder.append(RandomUtils.nextInt(LOWER_BOUND, UPPER_BOUND));
        }

        return stringBuilder.toString();
    }
}
