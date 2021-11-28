package baseball;

import static utils.Constant.*;

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
			return NOTHING;
		}

		String scoreStr = EMPTY_STRING;
		if (ball > 0) {
			scoreStr = scoreStr + ball + BALL + SPACE;
		}
		if (strike > 0) {
			scoreStr = scoreStr + strike + STRIKE;
		}
		return scoreStr;
	}
}
