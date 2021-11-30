package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.view.GameView;

public class GameController {
	private BaseBallGame baseBallGame;
	private GameView gameView;

	public GameController(BaseBallGame baseBallGame, GameView gameView) {
		this.baseBallGame = baseBallGame;
		this.gameView = gameView;
	}

	public void start() {
		while (baseBallGame.isRunning()) {
			String guess = gameView.askGuess();
			String report = baseBallGame.evaluate(guess);
			gameView.printResult(report);
		}
	}
}
