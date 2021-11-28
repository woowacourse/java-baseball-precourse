package baseball;

import static baseball.BaseballGame.TARGET_SIZE;
import static baseball.Computer.*;

public class InputValidator {

	public static boolean isRightGuessInput(String input) {
		if (hasOnlyNums(input) && isRightGuessLength(input)) {
			return true;
		}
		return false;
	}

	public static boolean isRightRestartInput(String input) {
		if (isRightRestartLength(input) && isRightRestartOption(input)){
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

	private static boolean isRightRestartLength(String input) {
		if (input.length() != RESTART_OPTION_SIZE) {
			return false;
		}
		return true;
	}

	private static boolean isRightRestartOption(String input) {
		if (hasOnlyNums(input)) {
			if (Integer.parseInt(input) == RESTART_YES || Integer.parseInt(input) == RESTART_NO) {
				return true;
			}
			return false;
		}
		return false;
	}
}
