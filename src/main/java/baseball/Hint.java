package baseball;

import static baseball.Message.*;
import static baseball.Rules.*;

public class Hint {
	private int strike;
	private int ball;

	public void countHint(int[] answer, String userInput) {
		initCount();
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			int userNumber = Character.getNumericValue(userInput.charAt(i));
			countStrike(userNumber, answer[i]);
			countBall(i, userNumber, answer);
		}
	}

	public void printResult() {
		StringBuilder stringBuilder = new StringBuilder();
		if (ball > 0) {
			stringBuilder.append(ball).append(BALL);
		}
		if (strike > 0) {
			stringBuilder.append(strike).append(STRIKE);
		}
		if (strike == 0 && ball == 0) {
			stringBuilder.append(NOTHING);
		}
		System.out.println(stringBuilder);
	}

	private void initCount() {
		this.strike = 0;
		this.ball = 0;
	}

	private void countStrike(int userNumber, int answerNumber) {
		if (userNumber == answerNumber) {
			this.strike++;
		}
	}

	private void countBall(int currentIdx, int userNumber, int[] answer) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			if (i != currentIdx && userNumber == answer[i]) {
				this.ball++;
			}
		}
	}

	public int getStrike() {
		return strike;
	}
}
