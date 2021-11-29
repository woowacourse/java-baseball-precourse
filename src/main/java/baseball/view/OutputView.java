package baseball.view;

public class OutputView {

	private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void printError(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printHint(String hintMessage) {
		System.out.println(hintMessage);
	}
}
