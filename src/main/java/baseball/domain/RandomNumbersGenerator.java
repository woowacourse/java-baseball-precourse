package baseball.domain;

import baseball.BaseballGame;
import utils.RandomUtils;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public String generateNumbers() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < BaseballGame.BALLS_LENGTH; i++) {
            stringBuilder.append(RandomUtils.nextInt(0, 10));
        }

        return stringBuilder.toString();
    }
}
