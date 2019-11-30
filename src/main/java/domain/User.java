package domain;

import java.util.Scanner;

public class User {
	private String numbers;
	private static final int LEN_NUMBERS = 3;
	
	public User() {
		numbers = "";
	}
	
	public String getNumber() {
		return numbers;
	}
	
	public void enterNumber() {
		Scanner numScanner = new Scanner(System.in);
		
		do {
			System.out.print("숫자를 입력해주세요: ");
			numbers = numScanner.nextLine();
			if(!isValidNumber()) {
				System.out.print("잘못된 입력입니다. 다시 ");
			}
		} while (!isValidNumber());
	}

	private boolean isValidNumber() {
		if(numbers.length() != LEN_NUMBERS) {
			return false;
		} else if (!isAllOneDigitNumber()) {
			return false;
		}
		return true;
	}
	
	private boolean isAllOneDigitNumber() {
		for(int i=0;i<numbers.length();i++) {
			char charAtI = numbers.charAt(i);
			if((charAtI < '0') || (charAtI > '9')) {
				return false;
			}
		}
		return true;
	}
}
