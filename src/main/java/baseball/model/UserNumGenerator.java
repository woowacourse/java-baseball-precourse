package baseball.model;

import baseball.view.InputView;

public class UserNumGenerator {
	public final int[] NUMS;

	public UserNumGenerator() {
		this.NUMS = pickUserNums();
	}

	private static int[] pickUserNums() throws IllegalArgumentException {
		String numString = InputView.startInput();
		int[] nums = Util.stringToIntArray(numString);
		if (isNotException(nums)) {
			return nums;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isNotException(int[] nums) {
		return nums.length == 3 && Util.isOneNineInt(nums) && Util.isNotDuplicate(nums);
	}
}
