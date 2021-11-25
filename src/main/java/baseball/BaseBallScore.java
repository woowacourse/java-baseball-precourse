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

	public void countScore(List<Integer> randomNumber, BaseBallPlayer baseBallPlayer) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			int result = baseBallPlayer.checkNumber(randomNumber.get(i), i);
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

	public boolean isAllStrike() {
		return strike == NUMBER_LENGTH;
	}
}
