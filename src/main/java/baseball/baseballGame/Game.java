package baseball.baseballGame;

import utils.RandomUtils;

import java.util.List;

public class Game {
    private List<Integer> answer;
    private static final int NUM_SIZE = 3;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    public Game() {
        makeAnswer();
    }

    private void makeAnswer() {
        for (int i = 0; i < NUM_SIZE; i++) {
            answer.add(RandomUtils.nextInt(MIN_NUM, MAX_NUM));
        }
    }

    public void run(){}
}
