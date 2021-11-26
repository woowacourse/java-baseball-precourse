package baseball.exception;

import baseball.view.InputView;

public class InputException {
	private static final String INVALID_INPUT_ERROR = "입력값 오류입니다. 게임 종료";
	private static final int NUMBER_LENGTH = 3;

	public static String validationCheck(String input) {

	}
	/**
	 * 	유저의 입력값이 정수가 아닌 다른 값을 입력받았을 때 예외 처리
	 */

	/**
	 * 유저의 입력값이 3자리가 아닌 숫자가 들어왔을 때 예외 처리
	 */
	private static boolean isThreeLength(String input) {
		if (input.length() == NUMBER_LENGTH) {
			return true;
		}
		return false;
	}

	/**
	 * 유저의 입력값에 중복이 있으면 예외처리
	 */

	/**
	 * 유저의 입력값에 0 이 들어있으면 예외처리(1~9까지만 받는다.)
	 */

	/**
	 * 게임 재시작 여부를 묻는 입력이 범위를 넘어갈때 예외 처리 (ex) 1, 2가 아닐떄)
	 */

}
