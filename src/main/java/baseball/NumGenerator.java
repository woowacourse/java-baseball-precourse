package baseball;

public class NumGenerator {
	public int[] nums;

	public static boolean isNotSame(int[] nums) {
		return nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2];
	}
}
