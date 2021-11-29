package baseball;

import java.util.ArrayList;
import java.util.Collections;

public class Exception {
	private static final String NUMBER_LENGTH_ERROR_MESSAGE = "잘못된 길이의 숫자를 입력했습니다.";
	private static final String NUMBER_OVERLAP_ERROR_MESSAGE = "동일한 숫자를 입력했습니다.";

	public static void inputExceptionCheck(ArrayList<Integer> userInputNumbers) {
		if (!isValidNumberOverlap(userInputNumbers)) {
			throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
		}
		if (!isValidNumberLength(userInputNumbers)) {
			throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
		}
	}

	public static boolean isValidNumberOverlap(ArrayList<Integer> userInputNumbers) {
		for (Integer i : userInputNumbers) {
			if (Collections.frequency(userInputNumbers, i) > 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidNumberLength(ArrayList<Integer> userInputNumbers) {
		if (userInputNumbers.size() != RandomNumber.PICK_NUMBER) {
			return false;
		}
		return true;
	}
}
