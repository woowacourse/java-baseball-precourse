package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class PlayerInput {

	private final int NUM_OF_DIGIT;

	private final char START_CHAR = '1';
	private final char END_CHAR = '9';

	public PlayerInput(int numOfDigit){
		NUM_OF_DIGIT = numOfDigit;
	}

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

	private boolean isValidInput(String readLine) {
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

	private boolean isValidNumber(char number) {
		if (number < START_CHAR || number > END_CHAR) {
			return false;
		}
		return true;
	}
}
