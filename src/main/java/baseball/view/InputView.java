package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String GAME_PROGRESS = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String GAME_USER_INPUT = "숫자를 입력해주세요 : ";

	public static String getGameProgress() {
		System.out.println(GAME_PROGRESS);
		return Console.readLine();
	}

	public static String getGameUserInput() {
		System.out.print(GAME_USER_INPUT);
		return Console.readLine();
	}
}
