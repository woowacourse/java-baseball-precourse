package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserNumGenerator extends IllegalArgumentException {
	public int[] nums;

	public UserNumGenerator() {
		this.nums = pickThreeNum();
	}

	public static int[] pickThreeNum() {
		System.out.print("숫자를 입력해주세요 : ");
		String numsString = Console.readLine();
		int[] nums = stringToIntArray(numsString);
		if (isThreeLength(nums) && isOneNineInt(nums) && isNotSame(nums)) {
			return nums;
		}
		throw new IllegalArgumentException();
	}

	public static int[] stringToIntArray(String str) {
		int[] nums = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			nums[i] = str.charAt(i) - '0';
		}
		return nums;
	}

	public static boolean isOneNineInt(int[] nums) {
		for (int num : nums) {
			if (num < 1 || num > 9) {
				return false;
			}
		}
		return true;
	}

	public static boolean isThreeLength(int[] nums) {
		return nums.length == 3;
	}

	public static boolean isNotSame(int[] nums) {
		return nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2];
	}
}
