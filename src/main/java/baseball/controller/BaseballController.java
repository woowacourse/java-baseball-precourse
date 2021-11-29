package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.domain.UserInput;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

	public static void readyPlay() {
		do {
			play();
		} while (proceedGame());
	}

	public static void play() {
		Computer computer = new Computer();
		boolean gameFlag = true;

		while (gameFlag) {
			gameFlag = compareNumber(computer, getUserInput());
		}
	}

	public static boolean compareNumber(Computer computer, UserInput userInput) {
		GameResult gameResult = new GameResult(computer, userInput);
		OutputView.printHint(gameResult.getHint());

		if (!gameResult.endGame()) {
			return true;
		}

		OutputView.printGameEnd();
		return false;
	}

	public static UserInput getUserInput() {
		UserInput userInput;

		try {
			userInput = new UserInput(InputView.getGameUserInput());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			throw e;
		}

		return userInput;
	}

	public static boolean proceedGame() {
		try {
			Game game = new Game(InputView.getGameProgress());
			return game.proceedGame();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			throw e;
		}
	}

}
