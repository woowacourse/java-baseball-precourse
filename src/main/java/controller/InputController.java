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
		return Integer.parseInt(gameFlag);
	}
}
