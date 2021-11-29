package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	static final String START_MESSAGE = "숫자를 입력해주세요 : ";
	static final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private String inputBallNumbers;
	private String inputRestartOrExit;

	public void printStartMessage() {
		System.out.print(START_MESSAGE);
	}

	public void setInputBallNumbers() {
		inputBallNumbers = Console.readLine();
	}

	public String getInputBallNumbers() {
		return inputBallNumbers;
	}

	public void printRestartOrExitMessage() {
		System.out.println(RESTART_OR_EXIT_MESSAGE);
	}

	public void setInputRestartOrExit() {
		inputRestartOrExit = Console.readLine();
	}

	public String getInputRestartOrExit() {
		return inputRestartOrExit;
	}
}
