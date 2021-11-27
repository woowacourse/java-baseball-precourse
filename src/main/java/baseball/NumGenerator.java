package baseball;

import java.util.Arrays;

public class NumGenerator {
	public int[] nums;

	public static boolean isNotDuplicate(int[] nums) {
		return nums.length == Arrays.stream(nums).distinct().count();
	}
}

