package baseball;

import static resource.MessageResource.*;

public class Referee {
	private static final int ZERO_COUNT = 0;

	private BaseBallNumber computer;

	public Referee(BaseBallNumber computer) {
		this.computer = computer;
	}

	public boolean isAllStrike(String inputBallNumber) {
		checkBallCount(inputBallNumber);
		if (computer.getBallNumber().equals(inputBallNumber)) {
			System.out.println(ALL_STRIKE_MESSAGE);
			return true;
		}
		return false;
	}

	private void checkBallCount(String inputBallNumber) {
		int ball = 0;
		int strike = 0;
		for (int i = 0; i < inputBallNumber.length(); i++) {
			if (computer.getBallNumber().charAt(i) == inputBallNumber.charAt(i)) {
				strike++;
				continue;
			}

			if (computer.getBallNumber().contains(inputBallNumber.substring(i, i + 1))) {
				ball++;
			}
		}
		printBallCount(ball, strike);
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
