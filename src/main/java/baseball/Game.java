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
        Hint hint = new Hint();
        boolean isCorrect;

        do {
            System.out.print(Message.INPUT_MESSAGE);
            input = InputUtil.getPlayerAnswer();
            isCorrect = checkAnswer(randomNum, input);

            hint.countStrikeAndBall(randomNum, input);
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
