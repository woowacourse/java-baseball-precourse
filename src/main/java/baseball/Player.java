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
		} else if (!Validator.isStrinNumber(number)) {
			throw new IllegalArgumentException("\n\t숫자를 입력해 주십시오.\n");
		} else if (!Validator.isUseable(number) ) {
			throw new IllegalArgumentException("\n\t1~9까지 서로 다른 값을 입력해 주십시오.\n");
		}
		setNumber(number);
	}
}
