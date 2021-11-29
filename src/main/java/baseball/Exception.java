package baseball;

import java.util.HashSet;
import java.util.Set;

public class Exception {
	private static final String NOT_NUMBER_ERROR_MESSAGE = "0 또는 숫자가 아닌 문자를 입력했습니다.";
	private static final String NUMBER_LENGTH_ERROR_MESSAGE = "잘못된 길이의 숫자를 입력했습니다.";
	private static final String NUMBER_OVERLAP_ERROR_MESSAGE = "동일한 숫자를 입력했습니다.";

	private static final String RESTART_INPUT = "1";
	private static final String GAME_OVER_INPUT = "2";
	private static final String NOT_RESTART_INPUT_ERROR_MESSAGE = "1 또는 2를 입력하지 않았습니다.";

	public static void validateNumberInput(String input) {
		if (!isValidNumberLength(input)) {
			throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);

		}
		if (!isValidNumberRange(input)) {
			throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
		}

		if (!isValidNumberOverlap(input)) {
			throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
		}
	}

	public static boolean isValidNumberLength(String input) {
		if (input.length() != RandomNumber.PICK_NUMBER) {
			return false;
		}
		return true;
	}

	public static boolean isValidNumberRange(String input) {
		for (int i = 0; i < input.length(); i++) {
			char number = input.charAt(i);
			if (!('1' <= number && number <= '9')) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidNumberOverlap(String input) {
		Set<Character> inputSet = new HashSet<>();
		for (int i = 0; i < RandomNumber.PICK_NUMBER; i++) {
			inputSet.add(input.charAt(i));
		}
		if (input.length() != inputSet.size()) {
			return false;
		}
		return true;
	}

	public static boolean isValidRestartInput(String restartInput) {
		if (restartInput.equals(RESTART_INPUT)) {
			return true;
		}
		if (restartInput.equals(GAME_OVER_INPUT)) {
			return false;
		}
		throw new IllegalArgumentException(NOT_RESTART_INPUT_ERROR_MESSAGE);
	}

}
