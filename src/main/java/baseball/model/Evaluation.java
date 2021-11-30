package baseball.model;

import static baseball.constants.GameConfig.*;

import java.util.List;

public class Evaluation {
	private List<GuessNumber> guessNumbers;
	private Answer answer;

	public Evaluation(List<GuessNumber> guessNumbers, Answer answer) {
		this.guessNumbers = guessNumbers;
		this.answer = answer;
	}

	public boolean isCorrect() {
		return countStrike() == MAX_STRIKE;
	}

	public boolean isNothing() {
		return !hasStrike() && !hasBall();
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
			if (guessNumber.isStrike(answer)) {
				count++;
			}
		}
		return count;
	}

	public int countBall() {
		int count = 0;
		for (GuessNumber guessNumber : guessNumbers) {
			if (guessNumber.isBall(answer)) {
				count++;
			}
		}
		return count;
	}
}
