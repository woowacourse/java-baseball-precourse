package baseball;

import java.util.Arrays;
import java.util.stream.Stream;

public class BaseballCount {
	public int ballCount = 0;
	public int strikeCount = 0;

	public BaseballCount(int[] userNums, int[] computerNums) {
		setBallCount(userNums, computerNums);
		setStrikeCount(userNums, computerNums);
	}

	private void setBallCount(int[] userNums, int[] computerNums) {
		ballCount = (int)Stream.iterate(0, i -> i + 1)
			.limit(Constant.NUMS_LENGTH)
			.filter(i -> userNums[i] != computerNums[i] && isInArray(userNums[i], computerNums))
			.count();
	}

	private void setStrikeCount(int[] userNums, int[] computerNums) {
		strikeCount = (int)Stream.iterate(0, i -> i + 1)
			.limit(Constant.NUMS_LENGTH)
			.filter(i -> userNums[i] == computerNums[i])
			.count();
	}

	private static boolean isInArray(int num, int[] nums) {
		return Arrays.stream(nums).anyMatch(arrayNum -> arrayNum == num);
	}
}

