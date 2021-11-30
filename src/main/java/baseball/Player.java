package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public static final String RESTART_ONE = "1";
	public static final String RESTART_TWO = "2";

	public int[] inputNumber = new int[Computer.NUMBER_SIZE];

	public int getInputNumber(int index) {
		return inputNumber[index];
	}

	public void setInputNumber(int index, int eachNumber) {
		this.inputNumber[index] = eachNumber;
	}

	public boolean isNumber(String inputNumber) {
		for (int i = 0; i < Computer.NUMBER_SIZE; i++) {
			if (!Character.isDigit(inputNumber.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public int toIntNumber(String inputNumber) {
		if (!isNumber(inputNumber) || inputNumber.length() != Computer.NUMBER_SIZE) {
			throw new IllegalArgumentException();
		}
		return Integer.parseInt(inputNumber);
	}

	public void scanInputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		String inputNumber = Console.readLine();
		int number = toIntNumber(inputNumber);
		saveInputNumber(number);
		isValidInput();
	}

	public boolean scanRestartNumber() {
		String inputNumber = Console.readLine();
		if (inputNumber.equals(RESTART_ONE)) {
			return true;
		} else if (inputNumber.equals(RESTART_TWO)) {
			return false;
		}
		throw new IllegalArgumentException();
	}

	public void saveInputNumber(int inputNumber) {
		setInputNumber(Application.HUNDREDS_NUMBER, inputNumber / 100);
		setInputNumber(Application.TENS_NUMBER, (inputNumber % 100) / 10);
		setInputNumber(Application.ONES_NUMBER, inputNumber % 10);
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
			if (getInputNumber(i) == 0) {
				return true;
			}
		}
		return false;
	}

	public void isValidInput() throws IllegalArgumentException {
		if (hasDuplicateNumber() || hasZero()) {
			throw new IllegalArgumentException();
		}
	}
}
