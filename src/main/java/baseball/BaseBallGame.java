package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
	private static final int NUM_OF_DIGIT = 3;
	private static final char START_CHAR = '1';
	private static final char END_CHAR = '9';
	
	public List<Integer> getInput() {
		String readLine = Console.readLine();
		List<Integer> inputNumbers = new ArrayList<>();
		if (!isValidInput(readLine)) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < NUM_OF_DIGIT; i++) {
			int num = readLine.charAt(i) - '0';
			inputNumbers.add(num);
		}
		return inputNumbers;
	}

	private static boolean isValidInput(String readLine) {
		int readLineLength = readLine.length();
		if(readLineLength != NUM_OF_DIGIT){
			return false;
		}
		for (int i = 0; i < NUM_OF_DIGIT; i++) {
			char number = readLine.charAt(i);
			if (!isValidNumber(number)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isValidNumber(char number) {
		if (number < START_CHAR || number > END_CHAR) {
			return false;
		}
		return true;
	}
}
