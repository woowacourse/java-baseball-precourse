package baseball.controller;

import baseball.domain.Game;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

	public static void play() {
		do {
			// TODO : 게임 진행
		} while (proceedGame());
	}

	public static boolean proceedGame() {
		OutputView.printGameProgress();
		try {
			Game game = new Game(Console.readLine());
			return game.proceedGame();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			throw e;
		}
	}

}
