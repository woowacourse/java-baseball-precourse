/*
 * NumberValidator.java    1.00  2019/03/27
 *
 * copyright by yuyu154
 * All rights reserved.
 */

/**
 * 입력한 문자열의 예외사항 검사를 담당하는 클래스
 */
public class NumberValidator {

	/**
	 * 입력받은 문자열이 3자리 길이의 숫자이면 true 반환
	 * @param inputString
	 * @return boolean
	 */
	public static boolean isValidNumbers(String inputString) {
		if (inputString.length() != 3) {
			return false;
		}
		for (int i = 0; i < inputString.length(); i++) {
			if (!isValidNumber(inputString.substring(i, i + 1))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 입력한 문자열이 1과 9 사이의 숫자이면 true 반환
	 * @param inputString
	 * @return boolean
	 */
	private static boolean isValidNumber(String inputString) {
		if (inputString.equals("0")) {
			return false;
		} else if(isNumber(inputString)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 입력한 문자열이 0과 9사이의 숫자이면 true 반환
	 * @param inputString
	 * @return boolean
	 */
	private static boolean isNumber(String inputString) {
		try {
			Integer.parseInt(inputString);
			return true;
		} catch (NumberFormatException exception) {
			return false;
		}
	}
}
