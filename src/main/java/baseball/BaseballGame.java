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
		Hint hint;
		computer.determineAnswerBalls();
		do {
			String predictionBalls = Player.predictBalls();
			hint = computer.compareBalls(predictionBalls);
			GameOutput.printHint(hint);
		} while (!isGameEnd(hint));
	}

	private boolean isGameEnd(Hint hint) {
		return hint.isPlayerWin();
	}
}
