/*
 * BaseballGame.java
 *
 * version 1.0
 *
 * 2020/11/27
 *
 * Copyright (c) 2020 Junhyoung Park
 */

package baseball;

import baseball.domain.RandomNumberGenerator;
import baseball.domain.Hint;
import baseball.domain.InputValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class BaseballGame {
    private Hint hint;

    private String setPlayNumber(Scanner scanner) {
        String playerNumber = InputView.inputPlayerNumber(scanner);
        InputValidation inputValidation = new InputValidation(playerNumber);
        if (!inputValidation.checkValidNumber()) {
            throw new IllegalArgumentException("잘못된 데이터 입니다.");
        }
        return playerNumber;
    }

    private boolean endGame() {
        if (hint.isWinning()) {
            OutputView.printWinning();
            return true;
        }
        return false;
    }

    private boolean newGame(Scanner scanner) {
        final int NEW_GAME = 1;
        final int EXIT = 2;
        int selectNumber = InputView.inputPlayOrNotNumber(scanner);
        if ((selectNumber != NEW_GAME) && (selectNumber != EXIT)) {
            throw new IllegalArgumentException("잘못된 데이터 입니다.");
        }
        return selectNumber == NEW_GAME;
    }

    private boolean playOrExit(Scanner scanner) {
        if (endGame()) {
            return !newGame(scanner);
        }
        return false;
    }

    public void play(Scanner scanner) {
        RandomNumberGenerator generateRandomNumber = new RandomNumberGenerator();
        String programNumber = generateRandomNumber.getRandomNumber();
        do {
            hint = new Hint(setPlayNumber(scanner), programNumber);
            hint.startGame();
            OutputView.printBallCount(hint.getBall(), hint.getStrike());
        } while(!playOrExit(scanner));
    }
}
