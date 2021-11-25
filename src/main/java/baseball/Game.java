package baseball;

import utils.InputUtil;
import utils.RandomUtil;

import java.util.List;

public class Game {

    public static final int NUM_LENGTH = 3;

    public void gameStart() {
        List<Integer> randomNum = RandomUtil.generateRandomNum();
        for (int i:randomNum) System.out.print(i);
        List<Integer> input;
        boolean isCorrect;

        do {
            input = InputUtil.getPlayerAnswer();
            isCorrect = checkAnswer(randomNum, input);
        } while (!isCorrect);

        System.out.println(Message.SUCCESS_MESSAGE);
    }

    private boolean checkAnswer (List<Integer> randomNum, List<Integer> input) {
        for (int i=0; i<NUM_LENGTH; i++) {
            if (randomNum.get(i) != input.get(i)) {
                return false;
            }
        }
        return true;
    }
}
