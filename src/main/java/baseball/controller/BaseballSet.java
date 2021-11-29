package baseball.controller;

import java.util.stream.Stream;

import baseball.model.Constant;
import baseball.model.Util;

public class BaseballSet {
	public final int BALL_COUNT;
	public final int STRIKE_COUNT;

	public BaseballSet(int[] userNums, int[] computerNums) {
		BALL_COUNT = setBallCount(userNums, computerNums);
		STRIKE_COUNT = setStrikeCount(userNums, computerNums);
	}

	private int setBallCount(int[] userNums, int[] computerNums) {
		return (int)Stream.iterate(0, i -> i + 1).limit(Constant.NUMS_LENGTH)
			.filter(i -> userNums[i] != computerNums[i] && Util.isInArray(userNums[i], computerNums))
			.count();
	}

	private int setStrikeCount(int[] userNums, int[] computerNums) {
		return (int)Stream.iterate(0, i -> i + 1).limit(Constant.NUMS_LENGTH)
			.filter(i -> userNums[i] == computerNums[i])
			.count();
	}

	public boolean isMaxStrike() {
		return STRIKE_COUNT == Constant.NUMS_LENGTH;
	}
}
