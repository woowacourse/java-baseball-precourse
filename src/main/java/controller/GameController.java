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
			giveGameHint(baseballGame);
			Display.pleaseInputNumbers();
			baseballGame.passPlayerNumbers(InputController.inputNumbers());
		}

		Display.finishGame(baseballGame.giveStrikeCount());
		Display.chooseNextGame();
	}

	private static void giveGameHint(BaseballGame baseballGame) {
		if (baseballGame.isNoHint()) {
			Display.showNothing();
		} else if (!baseballGame.isNoHint()) {
			showGameHints(baseballGame);
		}

		Display.enterBlank();
	}

	private static void showGameHints(BaseballGame baseballGame) {
		int ball = baseballGame.giveBallCount();
		int strike = baseballGame.giveStrikeCount();

		if (ball > 0) {
			Display.showBallCount(ball);
		}
		if (strike > 0) {
			Display.showStrikeCount(strike);
		}
	}
}
