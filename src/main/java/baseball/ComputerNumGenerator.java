package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumGenerator {
	public int[] nums = new int[3];

	public ComputerNumGenerator() {
		do {
			nums = pickThreeNum(nums);
		} while (!isNotSame(nums));
	}

	public static int[] pickThreeNum(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Randoms.pickNumberInRange(1, 9);
		}
		return nums;
	}

	public static boolean isNotSame(int[] nums) {
		return nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2];
	}
}
