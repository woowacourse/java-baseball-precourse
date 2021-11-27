package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumGenerator extends NumGenerator {
	public ComputerNumGenerator() {
		do {
			this.nums = pickComputerNums();
		} while (!isNotDuplicate(nums));
	}

	private static int[] pickComputerNums() {
		return Arrays.stream(new int[Constant.NUMS_LENGTH])
			.map(num -> Randoms.pickNumberInRange(1, 9))
			.toArray();
	}
}
