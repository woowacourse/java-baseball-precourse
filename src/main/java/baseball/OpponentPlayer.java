package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class OpponentPlayer {

	OpponentPlayer() {

	}

	private String pick3DigitNum() {
		String resultNum = "";
		for (int i = 0; i < 3; i++) {
			int random1DigitNum = Randoms.pickNumberInRange(1, 9);
			resultNum = resultNum.concat(Integer.toString(random1DigitNum));
		}
		return resultNum;
	}

	private boolean isUnique(String target3DigitNum) {
		if (target3DigitNum.charAt(0) == target3DigitNum.charAt(1)) {
			return false;
		}
		if (target3DigitNum.charAt(0) == target3DigitNum.charAt(2)) {
			return false;
		}
		if (target3DigitNum.charAt(1) == target3DigitNum.charAt(2)) {
			return false;
		}
		return true;
	}

	public String pickUnique3DigitNum() {
		String resultNum;
		do {
			resultNum = pick3DigitNum();
		} while (!isUnique(resultNum));
		return resultNum;
	}

}
