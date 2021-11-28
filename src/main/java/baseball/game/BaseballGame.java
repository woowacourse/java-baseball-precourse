package baseball.game;

import baseball.game.controller.RandomNumberController;

import static baseball.game.constants.BaseballGameConst.RESTART;
import static baseball.game.controller.HintController.*;
import static baseball.game.controller.UserInputController.*;

public class BaseballGame {

    private int[] randomNumbers;
    private int[] inputNumbers;
    private boolean correctAnswer;

    private RandomNumberController randomNumberController;

    public BaseballGame() {
        correctAnswer = false;
        randomNumberController = new RandomNumberController();
    }

    public int start() {
        //랜덤 숫자 생성
        randomNumbers = randomNumberController.getThreeRandomNumbers();

        for(int i:randomNumbers) System.out.println(i);

        while (!correctAnswer) {
            inputNumbers = getUserInput();
            correctAnswer = checkAnswer(randomNumbers, inputNumbers);
        }
        return askRestart();
    }

    public int askRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = getRestartInput();
        return input;
    }

}
