package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
	private static final String ASK_GUESS_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public GameView() {
	}

	public String askGuess() {
		System.out.print(ASK_GUESS_MESSAGE);
		return Console.readLine();
	}

	public void printResult(String report) {
		System.out.println(report);

	}

	public String askRestart() {
		System.out.println(ASK_RESTART_MESSAGE);
		return Console.readLine();
	}

}
