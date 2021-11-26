package com.model;

import com.io.Output;

public class Result {
	private static final int COUNT_ZERO = 0;
	private int strikeCount;
	private int ballCount;

	public Result(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public String getResult() {
		StringBuilder sb = new StringBuilder();

		if (strikeCount == COUNT_ZERO && ballCount == COUNT_ZERO) {
			sb.append(Output.RESULT_NOTHING_MESSAGE);
		}

		if (ballCount != COUNT_ZERO) {
			sb.append(ballCount).append(Output.RESULT_BALL_MESSAGE);
		}

		if (ballCount == COUNT_ZERO && strikeCount != COUNT_ZERO) {
			sb.append(strikeCount).append(Output.RESULT_STRIKE_MESSAGE);
		} else {
			sb.append(" ").append(strikeCount).append(Output.RESULT_STRIKE_MESSAGE);
		}

		return sb.toString();
	}

}
