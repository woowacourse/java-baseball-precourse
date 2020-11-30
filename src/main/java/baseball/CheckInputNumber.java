package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 입력한 문자열이 조건에 맞는지 검사하는 클래스
 */
public class CheckInputNumber {

	private static final String PLAYER_INPUT_EXCEPTION_MESSAGE = "3자리의 서로 다른 숫자를 입력해주세요.";
	private static final String PLAYER_RESTART_INPUT_EXCEPTION_MESSAGE = "1(다시 시작) 또는 2(종료)를 입력해주세요.";
	private final String[] oneOrTwo = {"1","2"};
	private final Scanner scanner;

	public CheckInputNumber(Scanner scanner){
		this.scanner = scanner;
	}

	public String inputNumber() {
		System.out.print(PLAYER_INPUT_EXCEPTION_MESSAGE);
		String input = scanner.nextLine();
		if (!isValid(input)) {
			throwInputException(PLAYER_INPUT_EXCEPTION_MESSAGE);
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

	public boolean isValidRestart(String input){
		if(oneOrTwo(input)){
			return true;
		}
		throwInputException(PLAYER_RESTART_INPUT_EXCEPTION_MESSAGE);
		return false;
	}

	private boolean isUnique(String input){
		Set<String> set = new HashSet<>();
		for(int i=0; i<input.length(); i++) {
			set.add(input.substring(i,i+1));
		}
		return (set.size()==3);
	}

	private boolean isValidInteger(char inputChar) {
		return !(inputChar < 49 || inputChar > 57);
	}

	private boolean oneOrTwo(String input){
		return (Arrays.stream(oneOrTwo).anyMatch(input::equals));
	}

	private void throwInputException (String exceptionMessage){
		throw new IllegalArgumentException(exceptionMessage);
	}
}
