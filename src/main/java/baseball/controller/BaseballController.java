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
			Computer computer = new Computer();
			play(computer);
		} while (proceedGame());
	}

	public static void play(Computer computer) {
		UserInput userInput;

		try {
			userInput = new UserInput(InputView.getGameUserInput());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			throw e;
		}

		compareNumber(computer, userInput);
	}

	public static void compareNumber(Computer computer, UserInput userInput) {
		GameResult gameResult = new GameResult(computer, userInput);
		OutputView.printHint(gameResult.getHint());
		
		if (!gameResult.endGame()) {
			play(computer);
		}
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
