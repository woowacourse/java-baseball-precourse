package controller;

import model.BaseballGame;
import view.OutputDisplay;

public class GameController {

	private GameController() {
	}

	public static void runGame() {
		int gameFlag = 1;

		while (gameFlag == 1) {
			playGame();
			gameFlag = InputController.chooseGameFlag();
		}
	}

	private static void playGame() {
		OutputDisplay.pleaseInputNumbers();
		BaseballGame baseballGame = new BaseballGame(InputController.inputNumbers());

		while (baseballGame.isNotGameOver()) {
			if (baseballGame.isNoHint()) {
				OutputDisplay.showNothing();
			} else if (!baseballGame.isNoHint()) {
				showGameHints(baseballGame);
			}
			OutputDisplay.pleaseInputNumbers();
			baseballGame.passPlayerNumbers(InputController.inputNumbers());
		}

		OutputDisplay.chooseNextGame(baseballGame.giveStrikeCount());
	}

	private static void showGameHints(BaseballGame baseballGame) {
		int ball = baseballGame.giveBallCount();
		int stirke = baseballGame.giveStrikeCount();

		if (ball > 0) {
			OutputDisplay.showBallCount(ball);
		}
		if (stirke > 0) {
			OutputDisplay.showStrikeCount(stirke);
		}

		OutputDisplay.enterBlank();
	}
}
