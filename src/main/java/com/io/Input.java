package com.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private static Console console;
	private static Output output;

	public static String receiveNumberInput() {
		output.printRequestNumberInput();
		String scanner = console.readLine();
		return scanner;
	}

}
