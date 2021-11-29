package domain;

public class PredictionResult {
	private final int ball;
	private final int strike;

	public PredictionResult(int ball, int strike) {
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
