package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public char[] inputNumber = new char[Computer.NUMBER_SIZE];

	public void scanInputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		String inputNumber = Console.readLine();
		saveInputNumber(inputNumber);
	}

	public void saveInputNumber(String inputNumber) {
		this.inputNumber = inputNumber.toCharArray();
	}
}
