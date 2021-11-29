package baseball.view;

public class OutputView {

	private static final String GAME_PROGRESS = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void printGameProgress() {
		System.out.println(GAME_PROGRESS);
	}

	public static void printError(String errorMessage) {
		System.out.println(errorMessage);
	}
}
