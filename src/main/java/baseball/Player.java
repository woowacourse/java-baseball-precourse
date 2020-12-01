package baseball;

import java.util.Scanner;

public class Player {
	Scanner scanner = new Scanner(System.in);

	public String inputNumbers() {
		System.out.println("1~9까지의 정수를 입력하세요.");

		String userInputNumbers = scanner.next();

		return userInputNumbers;
	}

	public char[] userNumbersArray(String string) {
		char[] userInputNumbersArray = string.toCharArray();

		Validator.checkRangeNumbers(userInputNumbersArray);
		Validator.checkOverlapInputNumbers(userInputNumbersArray);
		Validator.checkZeroNumbers(userInputNumbersArray);
		Validator.checkNotText(userInputNumbersArray);

		return userInputNumbersArray;
	}
}
