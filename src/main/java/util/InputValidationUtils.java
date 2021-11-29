package util;

import static baseball.Constants.*;

public class InputValidationUtils {
	private static final char MIN_NO = '1';
	private static final char MAX_NO = '9';

	public static boolean isCheckValid(String s) {
		if (isNumeric(s)) {
			return true;
		}
		if (!isDuplicate(s)) {
			return true;
		}
		if (isMaxLength(s)) {
			return true;
		}
		return false;
	}

	private static boolean isNumeric(String s) {
		for (int i = 0; i < s.length(); i++) {
			char num = s.charAt(i);
			if (num >= MIN_NO && num <= MAX_NO) {
				return true;
			}
		}
		return false;
	}

	private static boolean isDuplicate(String s) {
		for (int i = 0; i < s.length(); i++) {
			String remain = s.substring(i + 1);
			if (remain.contains(Character.toString(s.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	private static boolean isMaxLength(String s) {
		return s.length() == MAX_LENGTH;
	}
}
