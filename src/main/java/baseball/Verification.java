package baseball;

import static constant.Constant.*;

public class Verification {

	public static void ofReStartOrExitInput(String input) {

		isInteger(input);

		if (!input.equals(RE_START) && !input.equals(EXIT)) {
			throw new IllegalArgumentException(ERROR);
		}
	}

	public static void ofInput(String input) {

		isInteger(input);

		if (input.length() != INPUT_LENGTH) {
			throw new IllegalArgumentException(ERROR);
		}
	}

	private static void isInteger(String input) {

		if (!input.matches(INTEGER)) {
			throw new IllegalArgumentException(ERROR);
		}
	}
}
