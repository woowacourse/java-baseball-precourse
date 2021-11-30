package baseball;

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
