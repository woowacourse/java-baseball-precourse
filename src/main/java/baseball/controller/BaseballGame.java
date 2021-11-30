package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.views.GameOutput;

public class BaseballGame {

	private Computer computer;

	public BaseballGame() {
		this.computer = new Computer();
	}

	public void powerOn() {
		do {
			playGame();
		} while (Player.wantRestart());
	}

	private void playGame() {
		GameResult gameResult;
		computer.determineAnswerBalls();
		do {
			Balls predictionBalls = Player.predictBalls();
			gameResult = computer.compareBalls(predictionBalls);
			GameOutput.printHint(gameResult);
		} while (!isGameEnd(gameResult));
	}

	private boolean isGameEnd(GameResult gameResult) {
		return gameResult.isPlayerWin();
	}
}
