package domain;

public class Hint {
	private final int ball;
	private final int strike;

	public Hint(int ball, int strike) {
		this.ball = ball;
		this.strike = strike;
	}

	public int getBall() {
		return this.ball;
	}

	public int getStrike() {
		return this.strike;
	}
}
