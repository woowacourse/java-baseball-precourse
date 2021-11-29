package baseball.errorhandler;

import java.util.HashSet;

import baseball.constantstorage.Constant;

public class InputValidator {
	public static void checkPlayerAnswer(String input) {
		if (!(isNull(input) && isInteger(input) && is3digits(input) && isDifferentNumbers(input))) {
			throw new IllegalArgumentException();
		}
	}

	private static Boolean isNull(String input) {
		return input != null;
	}

	private static Boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	private static Boolean is3digits(String input) {
		int intInput = Integer.parseInt(input);
		return (int)(Math.log10(intInput) + 1) == Constant.NUMBER_LENGTH;
	}

	private static Boolean isDifferentNumbers(String input) {
		HashSet<Integer> hashSet = new HashSet<>();
		int intInput = Integer.parseInt(input);
		for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
			hashSet.add(intInput % 10);
			intInput /= 10;
		}
		return hashSet.size() == Constant.NUMBER_LENGTH;
	}

	public static void checkResumeAnswer(String input) {
		if (!(input.equals(Constant.RESUME) || input.equals(Constant.EXIT))) {
			throw new IllegalArgumentException();
		}
	}
}
