package baseball.view;

public class OutputView {

	public static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String GAME_EXIT_INSTRUCTION = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
		+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void printInputInstruction() {
		System.out.print(REQUEST_INPUT_MESSAGE);
	}

	public static void printRestartInstrunction() {
		System.out.println(GAME_EXIT_INSTRUCTION);
	}

	public static void printResult(String result) {
		System.out.println(result);
	}
}
