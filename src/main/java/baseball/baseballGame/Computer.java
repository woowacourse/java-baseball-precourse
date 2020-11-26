package baseball.baseballGame;

import utils.RandomUtils;

import java.util.List;

public class Computer {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    void makeAnswer(List<Integer> answer, int numSize) {
        for (int i = 0; i < numSize; i++) {
            answer.add(RandomUtils.nextInt(MIN_NUM, MAX_NUM));
        }
    }
}
