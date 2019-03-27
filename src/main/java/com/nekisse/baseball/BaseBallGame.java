package com.nekisse.baseball;

import java.util.List;

public class BaseBallGame {
    private GenerateRandomNumber generateRandomNumber;

    public BaseBallGame() {
        this.generateRandomNumber = new GenerateRandomNumber();
    }

    public void startGame() {
        GameTurnResult turnResult;
        Referee referee = new Referee(generateRandomNumber.createBaseballGameNumbers());
        do {
            List<Integer> userInputNumber = InputUtils.convertInputToBaseBallNumbers(InputView.printMenu());
            turnResult = referee.compareGameNumberResult(userInputNumber);
            OutputView.printTurnResult(turnResult);
        }
        while (!turnResult.isEnd());
        OutputView.printThreeStrikeGameEnd();
    }
}
