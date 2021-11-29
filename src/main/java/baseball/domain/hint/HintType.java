package baseball.domain.hint;

public enum HintType {
	STRIKE("스트라이크"),
	BALL("볼"),
	MISS("미스");

	private String name;

	HintType(String name) {
		this.name = name;
	}

	public String represent(int count) {
		if (count == 0) {
			return "";
		}
		return count + name;
	}
}
