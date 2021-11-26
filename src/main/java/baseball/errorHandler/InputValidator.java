package baseball.errorHandler;

import java.util.HashSet;

public class InputValidator {
	public void checkPlayerAnswer(String input) {
		if (!(isNull(input) && isInteger(input) && is3digits(input) && isDifferentNumbers(input))) {
			throw new IllegalArgumentException();
		}
	}

	private Boolean isNull(String input) {
		return input != null;
	}

	private Boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	private Boolean is3digits(String input) {
		int intInput = Integer.parseInt(input);
		return 99 < intInput && intInput < 1000;
	}

	private Boolean isDifferentNumbers(String input) {
		HashSet<Integer> hashSet = new HashSet<>();
		int intInput = Integer.parseInt(input);
		for (int i = 0; i < 3; i++) {
			hashSet.add(intInput % 10);
			intInput /= 10;
		}
		return hashSet.size() == 3;
	}

	public void checkResumeAnswer(String input) {
		if (!(input.equals("1") || input.equals("2"))) {
			throw new IllegalArgumentException();
		}
	}
}
