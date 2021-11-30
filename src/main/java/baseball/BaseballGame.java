package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
	private static final String RESTART = "1";
	private static final String EXIT = "2";

	public boolean checkRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String input = Console.readLine();
		validateInput(input);
		return input.equals(RESTART);
	}

	private void validateInput(String input) {
		if (!input.equals(RESTART) && !input.equals(EXIT)) {
			throw new IllegalArgumentException();
		}
	}
}
