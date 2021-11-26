package baseball.view;

public class OutputView {
	private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크";
	private static final String BALL_MESSAGE = "%d볼";
	private static final String STRIKE_MESSAGE = "%d스트라이크";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final int ZERO_COUNT = 0;

	public static void hintMessage(int ballCounts, int strikeCounts) {
		if (ballCounts == ZERO_COUNT && strikeCounts == ZERO_COUNT) {
			System.out.println(NOTHING_MESSAGE);
			return;
		}
		if (ballCounts == ZERO_COUNT) {
			System.out.printf(STRIKE_MESSAGE, strikeCounts);
			return;
		}
		if (strikeCounts == ZERO_COUNT) {
			System.out.printf(BALL_MESSAGE, ballCounts);
			return;
		}
		System.out.printf(BALL_AND_STRIKE_MESSAGE, ballCounts, strikeCounts);
	}
}
