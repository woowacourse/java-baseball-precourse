package baseball.domain;

public class GameBoard {
	private long strikeCount;
	private long ballCount;

	public GameBoard(long strikeCount, long ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public long getStrikeCount() {
		return strikeCount;
	}

	public long getBallCount() {
		return ballCount;
	}
}