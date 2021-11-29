package controller;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
	private static final String NUMBER_PATTERN = "^[1-2]*$";

	private InputController() {
	}

	public static String[] inputNumbers() {
		return Console.readLine().split("");
	}

	public static int chooseGameFlag() {
		String gameFlag = Console.readLine();
		return isValidationGameFlag(gameFlag);
	}

	private static int isValidationGameFlag(String gameFlag) {
		int inputNumber = Integer.parseInt(gameFlag);

		if (!Pattern.matches(NUMBER_PATTERN, gameFlag)) {
			throw new IllegalArgumentException("입력한 숫자중 잘못된 숫자(문자, 음수 등)이 있습니다.");
		}

		if (gameFlag.length() != 1) {
			throw new IllegalArgumentException("입력한 숫자가 한자리가 아닙니다.");
		}

		if (inputNumber != 1 && inputNumber != 2) {
			throw new IllegalArgumentException("입력한 숫자가 1 또는 2가 아닙니다.");
		}

		return inputNumber;
	}
}
