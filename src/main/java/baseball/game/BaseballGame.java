package baseball.game;

import baseball.game.controller.RandomNumberController;
import baseball.game.controller.UserInputController;

public class BaseballGame {

    private int[] randomNumbers;
    private int[] inputNumbers;
    private boolean incorrectAnswer;

    private RandomNumberController randomNumberController;

    public BaseballGame() {
        incorrectAnswer = true;
        randomNumberController = new RandomNumberController();
    }

    public void start() {
        //랜덤 숫자 생성
        randomNumbers = randomNumberController.getThreeRandomNumbers();

        while (incorrectAnswer) {

            inputNumbers = UserInputController.getUserInput();
        }

    }

}
