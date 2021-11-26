package baseball;

public class OutputView {
	private static final String NOTHING = "낫싱";
	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";

	public void printResult(GameResult result) {
		System.out.println(changeResultToString(result));
		if (result.isEnd()) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}

	private String changeResultToString(GameResult result) {
		if (result.hasStrike() && result.hasBall()) {
			return result.getBall() + BALL + " " + result.getStrike() + STRIKE;
		}
		if (result.hasStrike()) {
			return result.getStrike() + STRIKE;
		}
		if (result.hasBall()) {
			return result.getBall() + BALL;
		}
		return NOTHING;
	}
}
