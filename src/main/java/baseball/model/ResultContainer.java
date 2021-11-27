package baseball.model;

import baseball.output.PrintMessage;

public class ResultContainer {
	private static final int COUNT_ZERO = 0;
	private int strikeCount;
	private int ballCount;

	public ResultContainer(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public String getResult() {
		StringBuilder sb = new StringBuilder();

		if (strikeCount == COUNT_ZERO && ballCount == COUNT_ZERO) {
			sb.append(PrintMessage.RESULT_NOTHING_MESSAGE.getMessage());
		}

		if (ballCount != COUNT_ZERO) {
			sb.append(ballCount).append(PrintMessage.RESULT_BALL_MESSAGE.getMessage());
		}

		if (ballCount == COUNT_ZERO && strikeCount != COUNT_ZERO) {
			sb.append(strikeCount).append(PrintMessage.RESULT_STRIKE_MESSAGE.getMessage());
		} else if (strikeCount != COUNT_ZERO) {
			sb.append(" ").append(strikeCount).append(PrintMessage.RESULT_STRIKE_MESSAGE.getMessage());
		}

		return sb.toString();
	}

}
