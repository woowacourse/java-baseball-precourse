package domain;

import java.util.Scanner;

public class User {
	private static final int LEN_NUMBERS = 3;
	private static final int NUMBER_BEFORE_ENTER = -1;
	
	private String numbersStr;
	private int numbers[];

	public User() {
		numbersStr = "";
		numbers = new int[LEN_NUMBERS];
		for(int i=0; i<LEN_NUMBERS; i++) {
			numbers[i] = NUMBER_BEFORE_ENTER;
		}
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void enterNumbers() {
		Scanner numScanner = new Scanner(System.in);

		do {
			System.out.print("숫자를 입력해주세요: ");
			numbersStr = numScanner.nextLine();
			if (!isValidNumbers()) {
				System.out.print("잘못된 입력입니다. 다시 ");
			}
		} while (!isValidNumbers());

		convertStrToNumbers();
	}

	private boolean isValidNumbers() {
		if (numbersStr.length() != LEN_NUMBERS) {
			return false;
		} else if (!isAllOneDigitNumber()) {
			return false;
		}
		return true;
	}

	private boolean isAllOneDigitNumber() {
		for (int i = 0; i < numbersStr.length(); i++) {
			char charAtI = numbersStr.charAt(i);
			if ((charAtI < '1') || (charAtI > '9')) {
				return false;
			}
		}
		return true;
	}

	private void convertStrToNumbers() {
		for (int i = 0; i < LEN_NUMBERS; i++) {
			numbers[i] = Character.getNumericValue(numbersStr.charAt(i));
		}
	}
}
