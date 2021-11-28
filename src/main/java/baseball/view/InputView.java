package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String REQUEST_INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String REQUEST_INPUT_RESUME_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static String inputBaseballNumbers() {
		System.out.print(REQUEST_INPUT_NUMBERS_MESSAGE);
		return Console.readLine();
	}

	public static String inputResumeOrEnd() {
		System.out.println(REQUEST_INPUT_RESUME_OR_END_MESSAGE);
		final String userInput = Console.readLine();
		return userInput;
	}
}