package utils;

import constants.ExitOption;


public class InputValidator {

	private static final int DIGIT_NUMBER = 3;

	public static boolean checkUserInputIsValid(final String userInput) {

		/* 자리수가 일치하는지 검사함 */
		if (DIGIT_NUMBER != userInput.length()) {
			return false;
		}

		/* 정수인지 아닌지, 0이 들어있는지 아닌지 검사함 */
		for (int i = 0; i < DIGIT_NUMBER; i++) {
			char temp = userInput.charAt(i);

			if (!Character.isDigit(temp) || temp == '0') {
				return false;
			}
		}
		return true;
	}

	public static boolean checkExitCommandIsValid(final String userInput) {

		/* 재시작 또는 종료 커맨드가 종료옵션 목록에 있는지 검사함 */
		for (ExitOption option : ExitOption.values()) {
			if (userInput.equals(option.getCommand())) {
				return true;
			}
		}
		return false;
	}
}
