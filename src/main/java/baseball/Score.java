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

	public String getScoreOfNumbers(ArrayList<Integer> answerNumberList, ArrayList<Integer> targetNumberList) {
		for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
			if (answerNumberList.get(i).equals(targetNumberList.get(i))) {
				strike++;
				continue;
			}
			if (answerNumberList.contains(targetNumberList.get(i))) {
				ball++;
			}
		}
		return getScoreToString();
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
