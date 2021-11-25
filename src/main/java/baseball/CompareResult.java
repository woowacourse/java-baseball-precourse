package baseball;

public enum CompareResult {
	BALL, STRIKE, NOTHING;

	public boolean isStrike() {
		return this == STRIKE;
	}

	public boolean isBall() {
		return this == BALL;
	}

	public boolean isNothing() {
		return this == NOTHING;
	}
}
