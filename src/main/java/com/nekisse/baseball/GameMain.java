package com.nekisse.baseball;

import java.util.List;

public class GameMain {

    public static void main(String[] args) {
        Computer computer = new Computer();
        GameTurnResult gameTurnResult;
        Referee referee = new Referee(computer.createBaseballGameNumbers());
        do {
            String userInput = InputView.printMenu();
            List<Integer> userInputGameNumbers = InputUtils.convertInputToBaseBallNumbers(userInput);
            gameTurnResult = referee.compareGameNumberResult(userInputGameNumbers);
            OutputView.printTurnResult(gameTurnResult);
        }
        while (!gameTurnResult.isEnd());
        OutputView.printThreeStrikeGameEnd();

    }

}
