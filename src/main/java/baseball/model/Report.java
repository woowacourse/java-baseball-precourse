package baseball.model;

public class Report {
	private static final String CORRECT_MESSAGE = "%d스트라이크" + "\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String STRIKE_MESSAGE = "%d스트라이크";
	private static final String BALL_MESSAGE = "%d볼";
	private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크";

	Evaluation evaluation;

	public Report(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public String getReport() {
		if (evaluation.isCorrect()) {
			return String.format(CORRECT_MESSAGE, evaluation.countStrike());
		}

		if (evaluation.isNothing()) {
			return NOTHING_MESSAGE;
		}

		if (!evaluation.hasBall()) {
			return String.format(STRIKE_MESSAGE, evaluation.countStrike());
		}

		if (!evaluation.hasStrike()) {
			return String.format(BALL_MESSAGE, evaluation.countBall());
		}

		return String.format(BALL_AND_STRIKE_MESSAGE, evaluation.countStrike(), evaluation.countBall());
	}

}
