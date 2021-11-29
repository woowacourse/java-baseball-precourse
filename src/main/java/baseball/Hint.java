package baseball;

import java.util.ArrayList;

import baseball.view.OutputView;

public class Hint {
	public static int ball;
	public static int strike;
	private static final int RESET_TO_ZERO = 0;

	public static void getHint(ArrayList<Integer> randomNumbers, ArrayList<Integer> userInputNumbers) {
		initBallAndStrike();
		countBallAndStrike(randomNumbers, userInputNumbers);
		OutputView.printBallAndStrikeCount(ball, strike);
	}

	public static void initBallAndStrike() {
		ball = RESET_TO_ZERO;
		strike = RESET_TO_ZERO;
	}

	public static void countBallAndStrike(ArrayList<Integer> randomNumbers, ArrayList<Integer> userInputNumbers) {
		for (int i = 0; i < userInputNumbers.size(); i++) {
			if (userInputNumbers.get(i).equals(randomNumbers.get(i))) {
				strike++;
				continue;
			}
			if (randomNumbers.contains(userInputNumbers.get(i))) {
				ball++;
			}
		}
	}
}
