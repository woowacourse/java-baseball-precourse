package baseball.controller;

import baseball.domain.RandomNumbers;
import baseball.domain.BaseBallNumbers;
import baseball.exception.InvalidContinueMessageFormatException;
import baseball.view.InputView;
import baseball.view.ResultView;

public class baseballGameController {

    private static final String isContinue = "1";
    private static final String isGameEnd = "2";
    private static final Integer threeStrike = 3;

    public static void run() {
        runBaseBallGame();
        checkContinue();
    }

    private static void runBaseBallGame() {
        int strikeCount = 0;
        int ballCount = 0;

        RandomNumbers randomNumbers = new RandomNumbers();
        while (strikeCount != threeStrike) {
            BaseBallNumbers baseBallNumbers = new BaseBallNumbers(InputView.requireBaseBallNumber());
            ballCount = baseBallNumbers.calculateBallCount(randomNumbers.randomNumbers());
            strikeCount = baseBallNumbers.calculateStrikeCount(randomNumbers.randomNumbers());
            ResultView.printResult(ballCount, strikeCount);
        }
        ResultView.printResultInfoMessage();
    }

    private static void checkContinue() {
        String continueMessage = InputView.askContinue();

        if (continueMessage.equals(isContinue)) {
            runBaseBallGame();
            return;
        }

        if (continueMessage.equals(isGameEnd)) {
            ResultView.printGameEnd();
            return;
        }

        throw new InvalidContinueMessageFormatException();
    }
}
