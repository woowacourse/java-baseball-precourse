package baseball.type;

public enum GameStatus {
	RESTART("1"), EXIT("2"), OPERATION("3");

	String tag;

	GameStatus(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}
}
