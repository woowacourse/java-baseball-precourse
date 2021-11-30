package baseball;

public enum Hint implements Comparable<Hint> {
	BALL("볼"),
	STRIKE("스트라이크"),
	NOTHING("낫싱");

	private final String name;

	Hint(String name) {
		this.name = name;
	}

	public boolean isBall() {
		return this == BALL;
	}

	public boolean isStrike() {
		return this == STRIKE;
	}
}
