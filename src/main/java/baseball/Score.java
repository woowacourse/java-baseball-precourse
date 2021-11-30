package baseball;

import static utils.Constant.*;

import java.util.ArrayList;

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

	public String getScoreOfNumbers(int[] answerNumbers, int[] targetNumbers) {
		for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
			if (answerNumbers[i] == targetNumbers[i]) {
				strike++;
				continue;
			}
			if (isContainNumbers(targetNumbers[i], answerNumbers)) {
				ball++;
			}
		}
		return getScoreToString();
	}

	private boolean isContainNumbers(int targetNumber, int[] numbers) {
		for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
			if (numbers[i] == targetNumber) {
				return true;
			}
		}
		return false;
	}

	private String getScoreToString() {
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
