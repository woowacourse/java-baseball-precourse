package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private String inputBallNumbers;
	private String inputExitOrRestart;

	public void printStartMessage() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public void setInputBallNumbers() {
		inputBallNumbers = Console.readLine();
	}

	public String getInputBallNumbers() {
		return inputBallNumbers;
	}

	public void printExitOrRestartMessage() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void setInputExitOrRestart() {
		inputExitOrRestart = Console.readLine();
	}

	public String getInputExitOrRestart() {
		return inputExitOrRestart;
	}
}
