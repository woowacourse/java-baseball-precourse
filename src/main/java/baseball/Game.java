package baseball;

import utils.InputUtil;
import utils.RandomUtil;

import java.util.List;

import static constant.Constant.*;

public class Game {

    public void gameStart() {
        List<Integer> randomNum = RandomUtil.generateRandomNum();
        List<Integer> input;
        Hint hint = new Hint();
        boolean isCorrect;

        do {
            System.out.print(INPUT_MESSAGE);
            input = InputUtil.getPlayerAnswer();
            isCorrect = checkAnswer(randomNum, input);

            hint.countStrikeAndBall(randomNum, input);
        } while (!isCorrect);

        System.out.println(SUCCESS_MESSAGE);
    }

    private boolean checkAnswer(List<Integer> randomNum, List<Integer> input) {
        for (int i = INITIAL_VALUE; i < NUM_LENGTH; i++) {
            if (randomNum.get(i) != input.get(i)) {
                return false;
            }
        }
        return true;
    }
}
