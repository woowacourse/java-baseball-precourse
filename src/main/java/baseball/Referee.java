package baseball;

import static resource.MessageResource.*;

public class Referee {
	private static final int ZERO_COUNT = 0;

	private String computer;

	public Referee(String computer) {
		this.computer = computer;
	}

	private void checkBallCount(String inputBallNumber) {
		int ball = 0;
		int strike = 0;
		for (int i = 0; i < inputBallNumber.length(); i++) {
			if (computer.charAt(i) == inputBallNumber.charAt(i)) {
				strike++;
				continue;
			}

			if (computer.contains(inputBallNumber.substring(i, i + 1))) {
				ball++;
			}
		}
	}

	private void printBallCount(int ball, int strike) {
		if (isNothing(ball, strike))
			return;

		StringBuilder ballCount = new StringBuilder();
		isBall(ball, ballCount);
		isStrike(strike, ballCount);

		System.out.println(ballCount.toString());
	}

	private boolean isNothing(int ball, int strike) {
		if (ball == ZERO_COUNT && strike == ZERO_COUNT) {
			System.out.println(BALL_COUNT_NOTHING);
			return true;
		}
		return false;
	}

	private void isBall(int ball, StringBuilder ballCount) {
		if (ball > ZERO_COUNT) {
			ballCount.append(ball).append(BALL_COUNT_BALL);
			ballCount.append(" ");
		}
	}

	private void isStrike(int strike, StringBuilder ballCount) {
		if (strike > ZERO_COUNT) {
			ballCount.append(strike).append(BALL_COUNT_STRIKE);
		}
	}

}
