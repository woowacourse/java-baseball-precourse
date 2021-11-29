package controller;

import model.BaseballGame;
import view.OutputDisplay;

public class GameController {

	private GameController() {
	}

	public static void runGame() {
		BaseballGame baseballGame = new BaseballGame();
		OutputDisplay.pleaseInputNumbers();
		InputController.inputNumbers();
	}
}
