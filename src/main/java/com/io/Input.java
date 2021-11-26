package com.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public static String receiveNumberInput() {
		Output.printRequestNumberInput();
		String inputNumber = Console.readLine();
		return inputNumber;
	}

	public static String receiveRestartInput() {
		Output.printRequestRestartNumberInput();
		String inputNumber = Console.readLine();
		return inputNumber;
	}

}
