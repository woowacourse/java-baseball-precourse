package baseball;

import java.util.Scanner;

public class Player {
	Scanner scanner = new Scanner(System.in);

	public void inputNumbers() {
		System.out.println("1~9까지의 정수를 입력하세요.");
		String userInputNumbers = scanner.next();	
	}
	
	public static char[] userNumbersArray(String userInputNumbers) {
		char[] userInputNumbersArray = userInputNumbers.toCharArray();
		return userInputNumbersArray;
	}
	
	
		
}
