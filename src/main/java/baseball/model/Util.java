package baseball.model;

import java.util.Arrays;

public class Util {
	public static boolean isNotDuplicate(int[] nums) {
		return nums.length == Arrays.stream(nums).distinct().count();
	}

	public static int[] stringToIntArray(String str) {
		return str.chars()
			.map(num -> num - '0')
			.toArray();
	}

	public static boolean isOneNineInt(int[] numArray) {
		return Arrays.stream(numArray)
			.allMatch(num -> 1 <= num && num <= 9);
	}

	public static boolean isInArray(int num, int[] nums) {
		return Arrays.stream(nums).anyMatch(arrayNum -> arrayNum == num);
	}
}
