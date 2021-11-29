package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int LENGTH_NUMBER = 3;

	public static String generateNumber() {
		int[] computerNumber = new int[LENGTH_NUMBER];
		int i = 0;
		do {
			int newNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (isOverlap(computerNumber, newNumber)) {
				continue;
			}
			computerNumber[i] = newNumber;
			i = i + 1;
		} while (i < LENGTH_NUMBER);

		return Arrays.toString(computerNumber).replaceAll("[^0-9]", "");
	}

	private static boolean isOverlap(int[] computerNumber, int newNumber) {
		return Arrays.stream(computerNumber).anyMatch(k -> k == newNumber);
	}
}
