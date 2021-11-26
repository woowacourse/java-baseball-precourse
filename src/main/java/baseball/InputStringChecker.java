package baseball;

import static baseball.SystemMessage.*;

/**
 * 입력값의 유효성을 체크하는 클래스
 */
public class InputStringChecker {

	/**
	 * 문자열이 3자리수 숫자인지 확인하는 기능
	 * @param inputString
	 * @return
	 */
	public static boolean checkStringIsNumbers(String inputString) {
		if (inputString.length() != GAME_STRING_LENGTH) {
			throw new IllegalArgumentException(INVALID_GAME_STRING_LENGTH);
		}
		for (int i = 0; i < inputString.length(); i++) {
			if (checkCharIsNumber(inputString.charAt(i)) != true) {
				throw new IllegalArgumentException(STRING_NOT_NUMBER);
			}
		}
		return true;
	}

	/**
	 * 하나의 문자가 숫자인지 확인하는 메서드
	 * @param inputChar
	 * @return
	 */
	public static boolean checkCharIsNumber(char inputChar) {
		if (inputChar < '0' || inputChar > '9') {
			return false;
		}
		return true;
	}

	/**
	 * 문자열이 1 혹은 2인지 확인하는 메서드
	 * @param inputString
	 * @return
	 */
	public static boolean checkStringIsOneOrTwo(String inputString) {
		char inputChar;
		if (inputString.length() != 1) {
			throw new IllegalArgumentException(STRING_LENGTH_NOT_ONE);
		}
		inputChar = inputString.charAt(0);
		if (inputChar == '1' || inputChar == '2') {
			return true;
		}
		throw new IllegalArgumentException(STRING_NOT_ONE_OR_TWO);
	}
}