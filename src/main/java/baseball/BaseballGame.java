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

	public void playGame() {
		Hint hint;
		computer.determineAnswerBalls();
		do {
			String prediction = Player.predictBalls();
			hint = computer.compareBalls(prediction);
		} while (isGameEnd(hint));
	}

	private boolean isGameEnd(Hint hint) {
		return hint.isPlayerWin();
	}
}
