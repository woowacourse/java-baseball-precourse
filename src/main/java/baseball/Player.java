package baseball;

import java.util.Scanner;

public class Player {
	private String number;

	private void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void input() {
		final Scanner scanner = new Scanner(System.in);
		String number;
		
		System.out.print("숫자를 입력해주세요 : ");
		number = scanner.next();
		
		if (number.length() != 3) {
			throw new IllegalArgumentException("\n\t세자리 수를 입력하시오.\n");
		}
		setNumber(number);
	}
}
