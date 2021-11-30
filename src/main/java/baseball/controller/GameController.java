package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.Evaluation;
import baseball.model.Report;
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

			Evaluation evaluation = baseBallGame.evaluate(guess);
			gameView.printReport(new Report(evaluation));

			if (evaluation.isCorrect()) {
				baseBallGame.endGame();

				String flag = gameView.askRestart();
				baseBallGame.setRunning(flag);
			}
		}
	}
}
