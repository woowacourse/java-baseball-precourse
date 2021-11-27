package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Target {
	private String targetNumber;

	private int rangeBegin = 1;
	private int rangeEnd = 9;
	private int length = 3;

	public Target() {
		generateTargetNumber();
	}

	public void generateTargetNumber() {
		targetNumber = "";
		for (int i = 0; i < length; i++) {
			targetNumber += pickNumberInRange(rangeBegin, rangeEnd);
		}
	}

	public int[] compareWith(String userNumber) {
		int ball = 0;
		int strike = 0;

		for (int u = 0; u < length; u++) {
			int index = isContained(userNumber.charAt(u));

			if (index < 0) {

			} else if (index == u) {
				strike++;
			} else if (index != u) {
				ball++;
			}
		}
		return new int[] {ball, strike};
	}

	public int isContained(char ch) {
		for (int i = 0; i < length; i++) {
			if (targetNumber.charAt(i) == ch) {
				return i;
			}
		}
		return -1;
	}

	public int getRangeBegin() {
		return this.rangeBegin;
	}

	public void setRangeBegin(int rangeBegin) {
		this.rangeBegin = rangeBegin;
	}

	public int getRangeEnd() {
		return this.rangeEnd;
	}

	public void setRangeEnd(int rangeEnd) {
		this.rangeEnd = rangeEnd;
	}

	public boolean isEqual(Target compare) {
		return this.targetNumber.equals(compare.targetNumber);
	}
}
