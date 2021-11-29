package controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {

	private InputController() {
	}

	public static String[] inputNumbers() {
		return Console.readLine().split("");
	}
}
