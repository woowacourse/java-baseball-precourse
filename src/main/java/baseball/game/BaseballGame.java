package baseball.game;

import baseball.game.controller.RandomNumberController;

import static baseball.game.controller.HintController.checkAnswer;
import static baseball.game.controller.UserInputController.getRestartInput;
import static baseball.game.controller.UserInputController.getUserInput;

public class BaseballGame {

    private final RandomNumberController randomNumberController;
    private int[] randomNumbers;
    private int[] inputNumbers;
    private boolean correctAnswer;

    public BaseballGame() {
        correctAnswer = false;
        randomNumberController = new RandomNumberController();
    }

    public int start() {
        //랜덤 숫자 생성
        randomNumbers = randomNumberController.getThreeRandomNumbers();

        //사용자 입력 및 힌트 출력
        while (!correctAnswer) {
            inputNumbers = getUserInput();
            correctAnswer = checkAnswer(randomNumbers, inputNumbers);
        }

        //재시작 여부 반환
        return askRestart();
    }

    public int askRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = getRestartInput();
        return input;
    }

}
