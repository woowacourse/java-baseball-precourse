/*
 * NumberValidator.java
 *
 */

/**
 * 입력한 문자열에 예외사항이 있는지 검사하는 클래스
 */
public class NumberValidator {
	/**
	 * 입력받은 문자열이 3자리 길이의 숫자인지 확인
	 * @param inputString
	 * @return
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
	 * 입력한 문자열이 1과 9 사이의 숫자인지 확인
	 * @param inputString
	 * @return
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
	 * 입력한 문자열이 0과 9사이의 숫자인지 확인
	 * @param inputString
	 * @return
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
