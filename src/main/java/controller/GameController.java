package controller;

import model.BaseballGame;
import view.OutputDisplay;

public class GameController {

	private GameController() {
	}

	public static void runGame() {
		BaseballGame baseballGame = new BaseballGame();
		OutputDisplay.pleaseInputNumbers();
		baseballGame.passPlayerNumbers(InputController.inputNumbers());

		if (baseballGame.isNoHint()) {
			OutputDisplay.showNothing();
		} else {
			showGameHints(baseballGame);
		}
	}

	private static void showGameHints(BaseballGame baseballGame) {
		int ball = baseballGame.giveBallCount();
		int stirke = baseballGame.giveStrikeCount();

		if (ball != 0) {
			OutputDisplay.showBallCount(ball);
		}
		if (stirke != 0) {
			OutputDisplay.showStrikeCount(stirke);
		}
	}
}
