package baseball.domain;

import baseball.constant.BaseballConst;

public class Result {
	private final int strikeCount;
	private final int ballCount;

	public Result(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public boolean isCorrect(){
		return strikeCount == BaseballConst.NUM_LEN_LIMIT;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
}
