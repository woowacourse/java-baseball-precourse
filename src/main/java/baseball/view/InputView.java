package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String NUMBER_INPUT_MSG = "숫자를 입력하세요 : ";
	public static final String GAME_RESTART_INPUT = "1";
	public static final String GAME_EXIT_INPUT = "2";
	private static final String ASK_GAME_RESTART_MSG = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
		GAME_RESTART_INPUT, GAME_EXIT_INPUT);

	public static String inputNumber() {
		System.out.print(NUMBER_INPUT_MSG);
		return Console.readLine();
	}

	public static String inputRestart() {
		System.out.println(ASK_GAME_RESTART_MSG);
		return Console.readLine();
	}
}
