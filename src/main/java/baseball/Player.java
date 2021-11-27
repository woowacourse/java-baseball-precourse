package baseball;

public class Player {

	private int strike;
	private int ball;
	private int[] playerInput;

	public void init(int[] playerInput) {
		this.strike = 0;
		this.ball = 0;

		setPlayerInput(playerInput);
	}

	private void addStrike() {
		strike++;
	}

	private void addBall() {
		ball++;
	}

	public void compareNum(int ansNum, int ansNumIdx) {
		for (int i = 0; i < playerInput.length; i++) {
			if (ansNum == playerInput[i]) {
				checkStrikeOrBall(ansNumIdx, i);
				return;
			}
		}
	}

	private void checkStrikeOrBall(int ansNumIdx, int playerNumIdx) {
		if (ansNumIdx == playerNumIdx) {
			addStrike();
			return;
		}
		addBall();
	}

	public void setPlayerInput(int[] playerInput) {
		this.playerInput = playerInput;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
