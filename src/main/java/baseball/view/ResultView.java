package baseball.view;

public class ResultView {

	static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	static final String BALL_MESSAGE = "볼";
	static final String STRIKE_MESSAGE = "스트라이크";
	static final String NOTHING_MESSAGE = "낫싱";

	public void printCorrectMessage() {
		System.out.println(CORRECT_MESSAGE);
	}

	public void printResult(int ball, int strike) {
		StringBuilder stringBuilder = new StringBuilder();

		if (ball > 0) {
			stringBuilder.append(ball).append(BALL_MESSAGE).append(" ");
		}
		if (strike > 0) {
			stringBuilder.append(strike).append(STRIKE_MESSAGE);
		}
		if (ball == 0 && strike == 0) {
			stringBuilder.append(NOTHING_MESSAGE);
		}
		System.out.println(stringBuilder.toString().trim());
	}
}
