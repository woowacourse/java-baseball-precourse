package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumGenerator {
	public int[] nums;

	public ComputerNumGenerator() {
		do {
			this.nums = pickThreeNum();
		} while (!isNotSame(nums));
	}

	public static int[] pickThreeNum() {
		return Arrays.stream(new int[3])
			.map(num -> Randoms.pickNumberInRange(1, 9))
			.toArray();
	}

	public static boolean isNotSame(int[] nums) {
		return nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2];
	}
}
