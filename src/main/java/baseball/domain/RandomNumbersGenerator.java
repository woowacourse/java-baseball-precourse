package baseball.domain;

import baseball.BaseballGame;
import utils.RandomUtils;

public class RandomNumbersGenerator implements NumbersGenerator {

    public static final int LOWER_BOUND = 1;

    public static final int UPPER_BOUND = 9;

    @Override
    public String generateNumbers() {
        String numbers = getRandomValues();
        while (hasDuplicateNumber(numbers)) {
            numbers = getRandomValues();
        }

        return numbers;
    }

    private String getRandomValues() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < BaseballGame.BALLS_LENGTH; i++) {
            stringBuilder.append(RandomUtils.nextInt(LOWER_BOUND, UPPER_BOUND));
        }

        return stringBuilder.toString();
    }

    private boolean hasDuplicateNumber(String input) {
        int deduplicatedNumbersLength = (int) input.chars().distinct().count();
        return deduplicatedNumbersLength != BaseballGame.BALLS_LENGTH;
    }
}
