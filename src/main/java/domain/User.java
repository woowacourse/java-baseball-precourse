package domain;

import java.util.Scanner;

public class User {
	private String numbersStr;
	private int numbers[];
	private static final int LEN_NUMBERS = 3;
	
	public User() {
		numbersStr = "";
		numbers = new int [LEN_NUMBERS];
	}
	
	public int[] getNumbers() {
		return numbers;
	}
	
	public void enterNumber() {
		Scanner numScanner = new Scanner(System.in);
		
		do {
			System.out.print("숫자를 입력해주세요: ");
			numbersStr = numScanner.nextLine();
			if(!isValidNumber()) {
				System.out.print("잘못된 입력입니다. 다시 ");
			}
		} while (!isValidNumber());
		
		convertStrToNumbers();
	}

	private boolean isValidNumber() {
		if(numbersStr.length() != LEN_NUMBERS) {
			return false;
		} else if (!isAllOneDigitNumber()) {
			return false;
		}
		return true;
	}
	
	private boolean isAllOneDigitNumber() {
		for(int i=0; i<numbersStr.length(); i++) {
			char charAtI = numbersStr.charAt(i);
			if((charAtI < '0') || (charAtI > '9')) {
				return false;
			}
		}
		return true;
	}
	
	private void convertStrToNumbers() {
		for(int i=0; i<LEN_NUMBERS; i++) {
			numbers[i] = Character.getNumericValue(numbersStr.charAt(i));
		}
	}
}
