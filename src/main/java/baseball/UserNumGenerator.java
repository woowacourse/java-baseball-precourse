package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserNumGenerator extends IllegalArgumentException {
	public int[] nums = new int[3];

	public UserNumGenerator() {
		this.nums = pickThreeNum(this.nums);
	}

	public static int[] pickThreeNum(int[] nums) {
		System.out.print("숫자를 입력해주세요 : ");
		String numsString = Console.readLine();
		System.out.println("numString: " + numsString);
		if (numsString == null || numsString.length() != 3) {
			// null, not len 3
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < nums.length; i++) {
			char numChar = numsString.charAt(i);
			if (Character.isDigit(numChar) && numChar != '0') {
				nums[i] = numChar - '0';
				continue;
			}
			// not num, 0
			throw new IllegalArgumentException();
		}
		if (!isNotSame(nums)) {
			// same num
			throw new IllegalArgumentException();
		}
		return nums;
	}

	public static boolean isNotSame(int[] nums) {
		return nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2];
	}
}
