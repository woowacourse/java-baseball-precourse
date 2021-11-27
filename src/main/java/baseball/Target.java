package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Target {
	private String targetNumber;

	private int rangeBegin = 1;
	private int rangeEnd = 9;
	private int length = 3;

	public void generateTargetNumber() {
		targetNumber = "";
		for (int i = 0; i < length; i++) {
			targetNumber += pickNumberInRange(rangeBegin, rangeEnd);
		}
	}

	public int[] compareWith(String userNumber) {
		int[] ballsAndStrikes = new int[2];
		// TODO: 비교기능
		return ballsAndStrikes;
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
