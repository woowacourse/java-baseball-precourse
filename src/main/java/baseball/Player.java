package baseball;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Player {
	final static int MAX_LENGTH = 3;
	final static int START_GAME = 1;
	final static int END_GAME = 2;
	final static int MAX_RANGE = 9;
	final static int MIN_RANGE = 1;

	public void inputThreeNumbers() {
		Scanner scanner = new Scanner(System.in);
		String inputNumbers = scanner.nextLine();
	}

	public void convertInputNumbersTOArray(String input) {
		Set<Character> numbersSet = new HashSet();
		char[] arrayNumbers = input.toCharArray();

		for (int i = 0; i < arrayNumbers.length; i++) {
			numbersSet.add(arrayNumbers[i]);
		}
	}

}
