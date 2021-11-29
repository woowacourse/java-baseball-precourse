package controller;

import model.BaseballGame;
import model.BaseballGameFlag;
import view.Display;

public class GameController {

	private GameController() {
	}

	public static void runGame() {
		BaseballGameFlag baseballGameFlag = new BaseballGameFlag();

		while (baseballGameFlag.isStartGameFlag()) {
			playGame();
			baseballGameFlag.chooseGameFlag(InputController.inputNumber());
		}
	}

	private static void playGame() {
		Display.pleaseInputNumbers();
		BaseballGame baseballGame = new BaseballGame(InputController.inputNumbers());

		while (baseballGame.isNotGameOver()) {
			if (baseballGame.isNoHint()) {
				Display.showNothing();
			} else if (!baseballGame.isNoHint()) {
				showGameHints(baseballGame);
			}
			Display.pleaseInputNumbers();
			baseballGame.passPlayerNumbers(InputController.inputNumbers());
		}

		Display.chooseNextGame(baseballGame.giveStrikeCount());
	}

	private static void showGameHints(BaseballGame baseballGame) {
		int ball = baseballGame.giveBallCount();
		int stirke = baseballGame.giveStrikeCount();

		if (ball > 0) {
			Display.showBallCount(ball);
		}
		if (stirke > 0) {
			Display.showStrikeCount(stirke);
		}

		Display.enterBlank();
	}
}
