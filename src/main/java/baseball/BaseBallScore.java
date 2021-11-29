package baseball;

import static constants.BaseBallConstant.*;

import java.util.List;

public class BaseBallScore {
	private Integer strike;
	private Integer ball;

	public BaseBallScore() {
		strike = 0;
		ball = 0;
	}

	public void countScore(BaseBallAnswerProvider baseBallAnswerProvider, BaseBallPlayer baseBallPlayer) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			int result = baseBallAnswerProvider.checkAnswer(baseBallPlayer, i);
			if (result == STRIKE_RESULT) {
				strike++;
			}
			if (result == BALL_RESULT) {
				ball++;
			}
		}
	}

	public String scoreString() {
		String message = "";
		if (strike == 0 && ball == 0) {
			return NOTHING_MESSAGE;
		}
		if (ball != 0) {
			message += ball + BALL_MESSAGE + " ";
		}
		if (strike != 0) {
			message += strike + STRIKE_MESSAGE;
		}
		return message;
	}

	private void resetScore() {
		ball = 0;
		strike = 0;
	}

	public boolean isAllStrike() {
		int strikeResult = strike;
		resetScore();
		return strikeResult == NUMBER_LENGTH;
	}
}
