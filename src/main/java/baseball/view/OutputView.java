package baseball.view;

public class OutputView {
	private static final String ONLY_BALL_MESSAGE = "%d볼\n";
	private static final String ONLY_STRIKE_MESSAGE = "%d스트라이크\n";
	private static final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String ALL_CORRECT_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void printOnlyBallMessage(int ball) {
		System.out.printf(ONLY_BALL_MESSAGE, ball);
	}

	public static void printOnlyStrikeMessage(int strike) {
		System.out.printf(ONLY_STRIKE_MESSAGE, strike);
	}

	public static void printBallAndStrikeMessage(int ball, int strike) {
		System.out.printf(BALL_STRIKE_MESSAGE, ball, strike);
	}

	public static void printNothingMessage() {
		System.out.println(NOTHING_MESSAGE);
	}

	public static void printGameEnd() {
		System.out.println(ALL_CORRECT_MESSAGE);
	}

}
