package baseball;

public class View {

	private static final String inputMessage = "숫자를 입력해주세요 : ";
	private static final String nothingMessage = "낫싱";
	private static final String ballMessage = "볼 ";
	private static final String strikeMessage = "스트라이크";
	private static final String successMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
		+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void input() {
		System.out.print(inputMessage);
	}

	public static void hint(Hint hint) {
		String hintResult = "";
		int strike = hint.strike();
		int ball = hint.ball();
		int nothing = hint.nothing();
		if (nothing == Balls.SIZE) {
			System.out.println(nothingMessage);
			return;
		}
		if (ball != 0) {
			hintResult += ball + ballMessage;
		}
		if (strike != 0) {
			hintResult += strike + strikeMessage;
		}
		System.out.println(hintResult);
	}

	public static void success() {
		System.out.println(successMessage);
	}
}