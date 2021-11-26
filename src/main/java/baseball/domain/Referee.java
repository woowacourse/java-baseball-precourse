package baseball.domain;

import java.util.Arrays;

import baseball.view.OutputView;

public class Referee {
	private static final int RESET_TO_ZERO = 0;
	private static final int NUMBER_LENGTH = 3;
	private int ball;
	private int strike;

	public Referee() {
		initBallAndStrike();
	}

	public void getJudgment(User user, Computer computer) {
		initBallAndStrike();

		Integer[] answer = computer.getAnswer();
		Integer[] userExpectedAnswer = user.getExpectedAnswer();

		for (int i = 0; i < userExpectedAnswer.length; i++) {
			int findIndex = Arrays.asList(answer).indexOf(userExpectedAnswer[i]);
			if (i == findIndex) {
				strike++;
			} else if (findIndex > -1) {
				ball++;
			}
		}
		getResult(ball, strike);

	}

	private void initBallAndStrike() {
		this.ball = RESET_TO_ZERO;
		this.strike = RESET_TO_ZERO;
	}

	public static void getResult(int ball, int strike) {
		if (ball == 0 && strike == 0) {
			OutputView.printNothingMessage();
		}
		if (ball > 0 && strike > 0) {
			OutputView.printBallAndStrikeMessage(ball, strike);
		} else if (ball > 0) {
			OutputView.printOnlyBallMessage(ball);

		} else if (strike > 0) {
			OutputView.printOnlyStrikeMessage(strike);
		}

	}

}
