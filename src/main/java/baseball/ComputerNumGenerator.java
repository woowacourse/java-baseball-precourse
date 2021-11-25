package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumGenerator {
	public int[] nums;

	public ComputerNumGenerator() {
		do {
			this.nums = pickThreeNum();
		} while (!isNotSame(nums));
	}

	public static int[] pickThreeNum() {
		int[] nums = new int[3];
		for (int i = 0; i < 3; i++) {
			nums[i] = Randoms.pickNumberInRange(1, 9);
		}
		return nums;
	}

	public static boolean isNotSame(int[] nums) {
		return nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2];
	}
}
