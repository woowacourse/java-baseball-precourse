package baseball;

import java.util.Arrays;

public class NumGenerator {
	public int[] nums;

	public static boolean isNotSame(int[] nums) {
		return nums.length == Arrays.stream(nums).distinct().count();
	}
}
