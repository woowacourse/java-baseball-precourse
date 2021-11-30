package baseball;

import camp.nextstep.edu.missionutils.Console;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class User {
	public static String getNumber(STATE userState) {
		System.out.print(userMessage(userState));
		String input = Console.readLine();
		UserNumber userNumber = new UserNumber(input, userState);

		return userNumber.userNumber;
	}

	public static String userMessage(STATE userState) {
		if (userState == STATE.END_STATE) {
			return MESSAGE.NEXT_STEP_MESSAGE;
		}
		return MESSAGE.USER_INPUT_NUMBER_MESSAGE;
	}

	public static boolean isContinue() {
		int nextStep = Integer.parseInt(getNumber(STATE.END_STATE)) - 1;
		STATE nextState = STATE.values()[nextStep];

		if (nextState == STATE.GAME_STATE) {
			return true;
		}
		if (nextState == STATE.END_STATE) {
			return false;
		}
		throw new IllegalArgumentException();
	}

}
