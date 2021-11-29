package baseball;

import java.util.ArrayList;

import baseball.view.OutputView;

public class Hint {
	public static int ball;
	public static int strike;

	public static void getHint(ArrayList<Integer> randomNumbers, ArrayList<Integer> userInputNumbers) {
		initBallAndStrike();
		countBallAndStrike(randomNumbers, userInputNumbers);
		OutputView.printBallAndStrikeCount(ball, strike);
	}

	public static void initBallAndStrike() {
		ball = 0;
		strike = 0;
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
