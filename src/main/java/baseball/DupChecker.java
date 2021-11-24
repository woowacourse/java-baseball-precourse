package baseball;

public class DupChecker {
	private final int[] checkArr;

	public DupChecker() {
		checkArr = new int[10];
	}

	public boolean check(int num) {
		if (checkArr[num] == 1) {
			return false;
		}

		checkArr[num] = 1;
		return true;
	}
}
