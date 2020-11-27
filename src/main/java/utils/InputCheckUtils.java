package utils;

import java.util.HashSet;

public class InputCheckUtils {
	private static final Integer MAX_NUMBER_RANGE = 9;
	private static final Integer MIN_NUMBER_RANGE = 1;
	
	private InputCheckUtils() {
	}

	public static boolean isAllUniqueElement(String input) {
		HashSet<Character> inputChracterSet = new HashSet<Character>();
		for (char ch : input.toCharArray()) {
			inputChracterSet.add(ch);
		}
		if (inputChracterSet.size() != input.length()) {
			return false;
		}
		return true;
	}

	public static boolean isNumber(String input) {
		if (isNull(input)) {
			return false;
		}
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static boolean isRightRange(String input) {
		for (char ch : input.toCharArray()) {
			int i = ch - '0';
			if (i > MAX_NUMBER_RANGE || i < MIN_NUMBER_RANGE) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNull(String input) {
		if (input == null || input.isEmpty()) {
			return true;
		}
		return false;
	}
}
