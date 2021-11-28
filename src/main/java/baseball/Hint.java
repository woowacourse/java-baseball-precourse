package baseball;

public class Hint {

	private int strikeCount;
	private int ballCount;

	public Hint(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	//view에서 출력을 위한 getter
	public int getBallCount() {
		return ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public boolean isPlayerWin() {
		return strikeCount == 3;
	}

	public boolean hasBall() {
		return ballCount > 0;
	}

	public boolean hasStrike() {
		return strikeCount > 0;
	}

	public boolean isNothing() {
		return !hasBall() && !hasStrike();
	}
}
