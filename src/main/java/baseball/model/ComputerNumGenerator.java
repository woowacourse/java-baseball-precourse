package baseball.model;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumGenerator {
	public final int[] NUMS;

	public ComputerNumGenerator() {
		int[] nums;
		do {
			nums = pickComputerNums();
		} while (!Util.isNotDuplicate(nums));
		NUMS = nums;
	}

	private static int[] pickComputerNums() {
		return Arrays.stream(new int[Constant.NUMS_LENGTH])
			.map(num -> Randoms.pickNumberInRange(1, 9))
			.toArray();
	}
}
