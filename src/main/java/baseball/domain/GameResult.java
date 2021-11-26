package baseball.domain;

public class GameResult {
	private static String resultMsg;
	private static final String STRIKE_MSG = "스트라이크";
	private static final String BALL_MSG = "볼";
	private static final String NOTHING_MSG = "낫싱";

	public static void setResultMsg(int strike, int ball) {
		if (strike == 0 && ball == 0) {
			resultMsg = NOTHING_MSG;
		} else if (strike > 0 && ball > 0) {
			resultMsg = String.format("%d%s %d%s", ball, BALL_MSG, strike, STRIKE_MSG);
		} else if (strike > 0) {
			resultMsg = strike + STRIKE_MSG;
		} else if (ball > 0) {
			resultMsg = ball + BALL_MSG;
		}
	}

	public static String getResultMsg() {
		return resultMsg;
	}
}
