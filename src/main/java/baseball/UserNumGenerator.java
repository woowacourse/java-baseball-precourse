package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class UserNumGenerator extends IllegalArgumentException {
	public int[] nums;

	public UserNumGenerator() {
		this.nums = pickThreeNum();
	}

	public static int[] pickThreeNum() {
		System.out.print("숫자를 입력해주세요 : ");
		String numString = Console.readLine();
		int[] nums = stringToIntArray(numString);
		if (nums.length == 3 && isOneNineInt(nums) && isNotSame(nums)) {
			return nums;
		}
		throw new IllegalArgumentException("IllegalArgumentException!");
	}

	public static int[] stringToIntArray(String str) {
		return str.chars()
			.map(num -> num - '0')
			.toArray();
	}

	public static boolean isOneNineInt(int[] nums) {
		return Arrays.stream(nums)
			.allMatch(num -> 1 <= num && num <= 9);
	}

	public static boolean isNotSame(int[] nums) {
		return nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2];
	}
}
