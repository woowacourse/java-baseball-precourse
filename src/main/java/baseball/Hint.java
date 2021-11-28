package baseball;

public class Hint {

	private int strikeCount;
	private int ballCount;

	public Hint(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public boolean isPlayerWin() {
		return strikeCount == 3;
	}
}
