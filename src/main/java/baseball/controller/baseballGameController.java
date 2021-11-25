package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.BaseBallNumbers;
import baseball.exception.InvalidContinueMessageFormatException;
import baseball.view.InputView;
import baseball.view.ResultView;

public class baseballGameController {

    public static void run() {
        runBaseBallGame();
        checkContinue();

    }

    private static void checkContinue() {
        String continueMessage = InputView.askContinue();

        if (continueMessage.equals("1")) {
            runBaseBallGame();
            return;
        }

        if (continueMessage.equals("2")) {
            ResultView.printGameEnd();
            return;
        }

        throw new InvalidContinueMessageFormatException();
    }

    private static void runBaseBallGame() {
        int strikeCount = 0;
        int ballCount = 0;

        Computer computer = new Computer();
        while (strikeCount != 3) {
            BaseBallNumbers baseBallNumbers = new BaseBallNumbers(InputView.requireBaseBallNumber());
            ballCount = baseBallNumbers.calculateBallCount(computer.randomNumbers());
            strikeCount = baseBallNumbers.calculateStrikeCount(computer.randomNumbers());
            ResultView.printResult(ballCount, strikeCount);
        }
        ResultView.printResultInfoMessage();
    }

}
