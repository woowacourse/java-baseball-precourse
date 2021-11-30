package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.domain.UserInput;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

	public static void playTotalGame() {
		do {
			playOneGame();
		} while (continueGame());
	}

	public static void playOneGame() {
		Computer computer = new Computer();
		boolean gameContinue = true;

		while (gameContinue) {
			gameContinue = compareNumber(computer, getGameUserInput());
		}

		OutputView.printGameEnd();
	}

	public static UserInput getGameUserInput() {
		UserInput userInput;

		try {
			userInput = new UserInput(InputView.getGameUserInput());
			return userInput;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			throw e;
		}
	}

	public static boolean compareNumber(Computer computer, UserInput userInput) {
		GameResult gameResult = new GameResult(computer, userInput);
		OutputView.printHint(gameResult.getHint());

		return gameResult.compareNumber();
	}

	public static boolean continueGame() {
		try {
			Game game = new Game(InputView.getGameProgress());
			return game.continueGame();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			throw e;
		}
	}

}
