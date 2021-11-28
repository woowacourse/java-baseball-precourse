package baseball;

import static baseball.BaseballGame.TARGET_SIZE;

public class InputValidator {

	public static boolean isRightGuessInput(String input) {
		if (hasOnlyNums(input) && isRightGuessLength(input)) {
			return true;
		}
		return false;
	}

	private static boolean hasOnlyNums(String input) {
		for (char c : input.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRightGuessLength(String input) {
		if (input.length() != TARGET_SIZE) {
			return false;
		}
		return true;
	}
}
