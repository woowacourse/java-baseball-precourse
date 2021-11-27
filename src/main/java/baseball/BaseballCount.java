package baseball;

import java.util.Arrays;

public class BaseballCount {
	public int ballCount = 0;
	public int strikeCount = 0;

	public BaseballCount(int[] userNums, int[] computerNums) {
		for (int i = 0; i < Constant.NUMS_LENGTH; i++) {
			if (userNums[i] == computerNums[i]) {
				strikeCount++;
				continue;
			}
			if (isInArray(userNums[i], computerNums)) {
				ballCount++;
			}
		}
	}

	private static boolean isInArray(int num, int[] nums) {
		return Arrays.stream(nums)
			.anyMatch(arrayNum -> arrayNum == num);
	}
}
