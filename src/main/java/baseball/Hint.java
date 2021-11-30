package baseball;

public enum Hint implements Comparable<Hint> {
	BALL,
	STRIKE,
	NOTHING;

	public boolean isBall() {
		return this == BALL;
	}

	public boolean isStrike() {
		return this == STRIKE;
	}
}
