package baseball;

public class Score {
	private int strike;
	private int ball;

	public Score() {
		strike = 0;
		ball = 0;
	}

	public void initializeScore() {
		strike = 0;
		ball = 0;
	}

	public void addStrike() {
		strike++;
	}

	public void addBall() {
		ball++;
	}

	public String getScoreToString() {
		if (ball == 0 && strike == 0) {
			return "낫싱";
		}

		String scoreStr = "";
		if (ball > 0) {
			scoreStr = scoreStr + ball + "볼 ";
		}
		if (strike > 0) {
			scoreStr = scoreStr + strike + "스트라이크";
		}
		return scoreStr;
	}
}
