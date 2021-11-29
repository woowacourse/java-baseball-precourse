package baseball;

import camp.nextstep.edu.missionutils.Console;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class User {
	private static final int NUMBER_LENGTH = 3;
	private static final String USER_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요: ";
	private static final int NEW_GAME = 1;
	private static final int END_GAME = 2;

	public static String getNumber() {
		System.out.println(USER_INPUT_NUMBER_MESSAGE);
		String userNumber = Console.readLine();

		isDigit(userNumber);
		isMatchLength(userNumber);
		isOverlap(userNumber);
		isContainZero(userNumber);

		return userNumber;
	}

	public static boolean isContinue() {
		String input = Console.readLine();
		isDigit(input);
		int nextStep = Integer.parseInt(input);
		if (nextStep == NEW_GAME) {
			return true;
		}
		if (nextStep == END_GAME) {
			return false;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isDigit(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	private static boolean isMatchLength(String number) {
		if (number.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	private static boolean isOverlap(String number) {
		char[] userNumber = number.toCharArray();

		if (userNumber[0] == userNumber[1] || userNumber[0] == userNumber[2] || userNumber[1] == userNumber[2]) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	private static boolean isContainZero(String number) {
		String zero = Character.toString('0');

		if (number.contains(zero)) {
			throw new IllegalArgumentException();
		}
		return true;

	}

}
