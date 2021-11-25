package baseball;

import java.util.ArrayList;
import java.util.List;

public class Hint {
	private int ball = 0;
	private int strike = 0;

	public Hint(int[] answerNumber, int[] inputNumber) {
		for (int i = 0; i < inputNumber.length; i++) {
			countStrikeOrBall(answerNumber, i, inputNumber[i]);
		}
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}

	public String getHintMessage() {
		List<String> sList = new ArrayList<>();

		if (this.ball == 0 && this.strike == 0)
			return Const.NOTHING;

		if (this.ball != 0)
			sList.add(ball + Const.BALL);

		if (this.strike != 0)
			sList.add(strike + Const.STRIKE);

		return String.join(" ", sList);
	}

	private boolean isBall(int[] answerNumber, int index, int num) {
		for (int i = 0; i < answerNumber.length; i++) {
			if (answerNumber[i] == num && i != index)
				return true;
		}

		return false;
	}

	private boolean isStrike(int[] answerNumber, int index, int num) {
		for (int i = 0; i < answerNumber.length; i++) {
			if (answerNumber[i] == num && i == index)
				return true;
		}

		return false;
	}

	private void countStrikeOrBall(int[] answerNumber, int index, int num) {
		if (isStrike(answerNumber, index, num)) {
			this.strike += 1;
			return;
		}

		if (isBall(answerNumber, index, num))
			this.ball += 1;

	}
}
