package utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 입력한 문자열이 조건에 맞는지 검사하는 클래스
 */
public class CheckInputNumber {

	private static final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요.";
	Scanner scanner;

	public CheckInputNumber(Scanner scanner){
		this.scanner = scanner;
	}

	public String inputNumber() {
		System.out.print(PLAYER_INPUT_MESSAGE);
		String input = scanner.nextLine();
		if (!isValid(input)) {
			return inputNumber();
		}
		return input;
	}

	private boolean isValid(String input) {

		if (input.length() != 3) {
			return false;
		}
		if(!isUnique(input)){
			return false;
		}
		for (int i = 0; i < input.length(); i++) {
			char num = input.charAt(i);
			if (!isValidInteger(num)) {
				return false;
			}
		}
		return true;
	}

	private boolean isUnique(String input){
		Set<String> set = new HashSet<>();
		for(int i=0; i<input.length(); i++) {
			set.add(input.substring(i,i+1));
		}
		if(set.size()==3){
			return true;
		}
		return false;
	}

	private boolean isValidInteger(char inputChar) {
		return !(inputChar < 49 || inputChar > 57);
	}

}
