package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public char[] inputNumber = new char[Computer.NUMBER_SIZE];

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
			if (!Character.isDigit(eachNumber))
				return false;
		}
		return true;
	}

	public boolean hasDuplicateNumber() {
		if (inputNumber[0] == inputNumber[1] || inputNumber[1] == inputNumber[2] || inputNumber[0] == inputNumber[2]) {
			return true;
		}
		return false;
	}

	public boolean hasZero() {
		for (int i = 0; i < Computer.NUMBER_SIZE; i++) {
			if (inputNumber[i] == '0') {
				return true;
			}
		}
		return false;
	}
}
