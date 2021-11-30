package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

class ThreeDifferentDigits {
	private String[] digitsArr;

	String[] getDigits() {
		return digitsArr;
	}

	ThreeDifferentDigits() {
		init3DiffDigits();
	}

	private void init3DiffDigits() {
		digitsArr = new String[3];
		int index = 0;
		while (index < 3) {
			index = changeNullOfIndex(index);
		}
	}

	private int changeNullOfIndex(int index) {
		int rand = Randoms.pickNumberInRange(1, 9);
		String strOfRand = Integer.toString(rand);

		if (Arrays.asList(digitsArr).contains(strOfRand)) {
			return index;
		}

		digitsArr[index] = strOfRand;

		index++;

		return index;
	}
}