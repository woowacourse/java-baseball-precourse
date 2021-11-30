package baseball;

import camp.nextstep.edu.missionutils.Console;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class User {
	private static final String USER_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요: ";
	private static final String NEXT_STEP_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
	private static final int NEW_GAME = 1;
	private static final int END_GAME = 2;

	public static String getNumber(STATE userState) {
		System.out.print(userMessage(userState));
		String input = Console.readLine();
		UserNumber userNumber = new UserNumber(input, userState);

		return userNumber.userNumber;
	}

	public static String userMessage(STATE userState) {
		if (userState == STATE.END_STATE) {
			return NEXT_STEP_MESSAGE;
		}
		return USER_INPUT_NUMBER_MESSAGE;
	}

	public static boolean isContinue() {
		String input = getNumber(STATE.END_STATE);
		int nextStep = Integer.parseInt(input);

		if (nextStep == NEW_GAME) {
			return true;
		}
		if (nextStep == END_GAME) {
			return false;
		}
		throw new IllegalArgumentException();
	}

}
