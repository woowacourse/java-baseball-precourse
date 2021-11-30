package baseball;

import baseball.controller.GameController;
import baseball.model.BaseBallGame;
import baseball.view.GameView;

public class Application {
	public static void main(String[] args) {
		BaseBallGame baseBallGame = new BaseBallGame();
		GameView gameView = new GameView();

		GameController gameController = new GameController(baseBallGame, gameView);
		gameController.start();
	}
}
