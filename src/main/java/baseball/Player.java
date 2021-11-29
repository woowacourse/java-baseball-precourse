package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public static final String RESTART_ONE = "1";
	public static final String RESTART_TWO = "2";

	public char[] inputNumber = new char[Computer.NUMBER_SIZE];

	public boolean scanRestartNumber() {
		String inputNumber = Console.readLine();
		if (inputNumber.equals(RESTART_ONE)) {
			return true;
		} else if (inputNumber.equals(RESTART_TWO)) {
			return false;
		}
		throw new IllegalArgumentException();
	}

	public char getInputNumber(int index) {
		return inputNumber[index];
	}

	public void scanInputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		String inputNumber = Console.readLine();
		saveInputNumber(inputNumber);
		isValidInput();
	}

	public void saveInputNumber(String inputNumber) {
		this.inputNumber = inputNumber.toCharArray();
	}

	public void isValidInput() throws IllegalArgumentException {
		if (inputNumber.length != Computer.NUMBER_SIZE || hasDuplicateNumber() || hasZero() || !isNumber()) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isNumber() {
		for (char eachNumber : inputNumber) {
			if (!Character.isDigit(eachNumber)) {
				return false;
			}
		}
		return true;
	}

	public boolean hasDuplicateNumber() {
		if (getInputNumber(Application.HUNDREDS_NUMBER) == getInputNumber(Application.TENS_NUMBER)
			|| getInputNumber(Application.TENS_NUMBER) == getInputNumber(Application.ONES_NUMBER)
			|| getInputNumber(Application.HUNDREDS_NUMBER) == getInputNumber(Application.ONES_NUMBER)) {
			return true;
		}
		return false;
	}

	public boolean hasZero() {
		for (int i = 0; i < Computer.NUMBER_SIZE; i++) {
			if (getInputNumber(i) == '0') {
				return true;
			}
		}
		return false;
	}
}
