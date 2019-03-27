package com.nekisse.baseball;

import com.nekisse.baseball.view.InputView;
import com.nekisse.baseball.view.OutputView;

public class BaseBallGame {
    private GenerateRandomNumber generateRandomNumber;

    public BaseBallGame() {
        this.generateRandomNumber = new GenerateRandomNumber();
    }

    public void startGame() {
        GameTurnResult turnResult = new GameTurnResult();
        Referee referee = new Referee(generateRandomNumber.createBaseballGameNumbers());
        do {
            try {
                BaseballNumbers userInputNumber = InputUtils.convertInputToBaseBallNumbersAndDuplicateNumberCheck(InputView.printMenu());
                turnResult = referee.compareGameNumberResult(userInputNumber);
            } catch (Exception e) {
                OutputView.printException(e);
            }
            OutputView.printTurnResult(turnResult);
        }
        while (!turnResult.isEnd());
        OutputView.printThreeStrikeGameEnd();
    }
}
