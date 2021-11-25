package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
	private static final int NUM_OF_DIGIT = 3;
	public List<Integer> getInput() {
		String readLine = Console.readLine();
		List<Integer> inputNumbers = new ArrayList<>();
		if (isValidInput(readLine)) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < NUM_OF_DIGIT; i++) {
			int num = readLine.charAt(i) - '0';
			inputNumbers.add(num);
		}
		return inputNumbers;
	}
}
