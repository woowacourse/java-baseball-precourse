package baseball.type;

public enum Hint {
	BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");

	private final String tag;

	Hint(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}
}
