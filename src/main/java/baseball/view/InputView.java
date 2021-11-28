package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private String inputBallNumbers;

	public void printStartMessage() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public void setInputBallNumbers() {
		inputBallNumbers = Console.readLine();
	}

	public String getInputBallNumbers() {
		return inputBallNumbers;
	}
}
