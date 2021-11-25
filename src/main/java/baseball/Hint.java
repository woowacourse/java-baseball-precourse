package baseball;

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
