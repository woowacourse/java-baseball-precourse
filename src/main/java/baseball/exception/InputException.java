package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class InputException {
	private static final String INVALID_INPUT_ERROR = "[ERROR] 잘못된 값을 입력했습니다. 게임을 종료하겠습니다.";
	private static final int NUMBER_LENGTH = 3;

	public static String validationCheck(String input) {
		if (isThreeLength(input) && isInteger(input) && haveNotDuplicatedNumber(input) && haveNotZero(input)) {
			return input;
		}
		throw new IllegalArgumentException(INVALID_INPUT_ERROR);
	}

	private static boolean isThreeLength(String input) {
		if (input.length() == NUMBER_LENGTH) {
			return true;
		}
		return false;
	}

	private static boolean isInteger(String input) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			if (!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static boolean haveNotDuplicatedNumber(String input) {
		Set<Character> inputSet = new HashSet<>();
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			inputSet.add(input.charAt(i));
		}
		if (inputSet.size() == input.length()) {
			return true;
		}
		return false;
	}

	private static boolean haveNotZero(String input) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			if ('0' == input.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 게임 재시작 여부를 묻는 입력이 범위를 넘어갈때 예외 처리 (ex) 1, 2가 아닐떄)
	 */

}
