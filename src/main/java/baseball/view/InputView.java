package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String GAME_PROGRESS = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static String printGameProgress() {
		System.out.println(GAME_PROGRESS);
		return Console.readLine();
	}
}
