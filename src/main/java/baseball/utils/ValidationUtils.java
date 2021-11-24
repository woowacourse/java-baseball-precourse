package baseball.utils;


import java.util.List;

import baseball.constants.GameConstants;

public class ValidationUtils {
	public static boolean validateRandomDigits(List<Integer> numberList) {
		boolean[] duplicateCheck = new boolean[GameConstants.RandomRange.END_INCLUSIVE.getNumber() + 1];

		for (Integer number : numberList) {
			if (duplicateCheck[number]) {
				return false;
			}
			duplicateCheck[number] = true;
		}
		return true;
	}

	public static boolean validateRandomDigitsLength(List<Integer> numberList) {
		return numberList.size() == GameConstants.RandomDigit.LENGTH.getNumber();
	}
}
