package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class UserNumGenerator extends NumGenerator {
	public UserNumGenerator() {
		this.nums = pickUserNums();
	}

	private static int[] pickUserNums() throws IllegalArgumentException {
		System.out.print("숫자를 입력해주세요 : ");
		String numString = Console.readLine();
		int[] nums = stringToIntArray(numString);
		if (nums.length == 3 && isOneNineInt(nums) && isNotDuplicate(nums)) {
			return nums;
		}
		throw new IllegalArgumentException("중복되지 않는 1-9 숫자 3개를 입력하세요!");
	}

	private static int[] stringToIntArray(String str) {
		return str.chars()
			.map(num -> num - '0')
			.toArray();
	}

	private static boolean isOneNineInt(int[] nums) {
		return Arrays.stream(nums)
			.allMatch(num -> 1 <= num && num <= 9);
	}
}
