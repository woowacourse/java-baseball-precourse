package domain;

import java.util.Scanner;

public class User {
	private String number;
	
	public User() {
		
	}
	
	String getNumber() {
		return number;
	}
	
	void enterNumber() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요: ");
		number = scanner.nextLine();
	}

}
