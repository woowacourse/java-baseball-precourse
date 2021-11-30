package baseball.model;

import java.util.List;

public class GuessNumbers {
	private List<GuessNumber> guessNumbers;

	public GuessNumbers(List<GuessNumber> guessNumbers) {
		this.guessNumbers = guessNumbers;
	}

	public boolean hasStrike() {
		return countStrike() > 0;
	}

	public boolean hasBall() {
		return countBall() > 0;
	}

	public int countStrike() {
		int count = 0;
		for (GuessNumber guessNumber : guessNumbers) {
			if (guessNumber.isStrike()) {
				count++;
			}
		}
		return count;
	}

	public int countBall() {
		int count = 0;
		for (GuessNumber guessNumber : guessNumbers) {
			if (guessNumber.isBall()) {
				count++;
			}
		}
		return count;
	}
}
