package domain;

public class CompareResult {
	private final int ball;
	private final int strike;

	public CompareResult(int ball, int strike) {
		this.ball = ball;
		this.strike = strike;
	}

	public int getBall() {
		return this.ball;
	}

	public int getStrike() {
		return this.strike;
	}

	public boolean isWin() {
		return this.strike == 3;
	}
}
