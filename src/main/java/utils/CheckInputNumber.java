/**
 * Copyright rinsabbit. All rights reserved.
 */

package utils;

/**
 * 입력한 문자열이 조건에 맞는지 검사하는 클래스
 */
public class CheckInputNumber {

	/**
	 * 입력한 문자열이 3자리 길이의 숫자면 true 반환
	 * @param inputNum
	 * @return boolean
	 */
	public boolean isValid(String inputNum) {

		if (inputNum.length() != 3) {
			return false;
		}
		for (int i = 0; i < inputNum.length(); i++) {
			char num = inputNum.charAt(i);
			if (!isValidInteger(num)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 입력한 문자가 1-9 사이의 숫자면 true 반환. 아스키코드로 검사.
	 * @param inputChar
	 * @return boolean
	 */
	private boolean isValidInteger(char inputChar) {

		if (inputChar < 49 || inputChar > 57) {
			return false;
		}
		return true;
	}

}
