package view;

import java.util.List;
import java.util.Scanner;

import domain.BaseballNumbers;

public class InputView {
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요";
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public static BaseballNumbers getBaseballNumbers() {
		try {
			System.out.println(INPUT_NUMBER_MESSAGE);
			return new BaseballNumbers(SCANNER.nextLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getBaseballNumbers();
		}
	}
	
}
