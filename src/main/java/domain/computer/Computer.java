package domain.computer;

import utils.RandomUtils;

public class Computer {
    private final static int START_VALUE_IN_RANDOM_NUMBER_RANGE = 1;
    private final static int END_VALUE_IN_RANDOM_NUMBER_RANGE = 9;
    int[] answer = new int[3];

    Computer() {
        makeRandomAnswer();
    }

    private void makeRandomAnswer() {
        for (int i = 0; i < answer.length; i++) {
            answer[i] = RandomUtils.nextInt(START_VALUE_IN_RANDOM_NUMBER_RANGE,
                                            END_VALUE_IN_RANDOM_NUMBER_RANGE);
        }
    }
}