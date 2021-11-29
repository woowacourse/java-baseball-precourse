package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
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
		// TODO : 게임 진행
	}

	public static boolean proceedGame() {
		try {
			Game game = new Game(InputView.printGameProgress());
			return game.proceedGame();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			throw e;
		}
	}

}
