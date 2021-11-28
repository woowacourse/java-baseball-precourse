package baseball.type;

public enum HintType {

	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫싱"),
	;

	private final String hint;

	HintType(String hint) {
		this.hint = hint;
	}

	public String getHint() {
		return hint;
	}
}
