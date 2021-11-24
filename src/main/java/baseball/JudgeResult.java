package baseball;

public class JudgeResult {
	private final int strike;

	public JudgeResult(int strike) {
		this.strike = strike;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return 0;
	}
}
