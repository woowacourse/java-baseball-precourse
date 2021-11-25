package baseball.view;

/**
 * 유저에게 결과를 보여주는 뷰 클래스
 */
public class OutputView {

	private static final String ASK_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String BALL = "볼 ";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";

	/**
	 * 숫자 입력을 요구하는 메시지를 출력하는 함수
	 */
	public static void askNumber() {
		System.out.print(ASK_NUMBER_MESSAGE);
	}

	/**
	 * new line을 출력하는 함수
	 */
	public static void printNewLine() {
		System.out.println();
	}

	/**
	 * 볼 개수와 볼을 출력하는 함수
	 *
	 * @param ballCount: int
	 */
	public static void printBall(int ballCount) {
		System.out.print(ballCount + BALL);
	}

	/**
	 * 스트라이크 개수와 스트라이크를 출력하는 함수
	 *
	 * @param strikeCount: int
	 */
	public static void printStrike(int strikeCount) {
		System.out.print(strikeCount + STRIKE);
	}

	/**
	 * 낫싱을 출력하는 함수
	 */
	public static void printNothing() {
		System.out.println(NOTHING);
	}
}
