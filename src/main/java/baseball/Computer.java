package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> randomGeneratedNumber;
	private int strike;
	private int ball;

	public void generateRandomNumber() {
		randomGeneratedNumber = new ArrayList<>();
		while (this.randomGeneratedNumber.size() < Constants.DIGIT_LENGTH) {
			int digit = Randoms.pickNumberInRange(Constants.LOWER_BOUND, Constants.UPPER_BOUND);
			if (!this.randomGeneratedNumber.contains(digit)) {
				this.randomGeneratedNumber.add(digit);
			}
		}
	}

	public void countScore(List<Integer> playerInput) {
		countStrike(playerInput);
		countBall(playerInput);
	}

	private void countStrike(List<Integer> playerInput) {
		int count = 0;
		for (int i = 0; i < Constants.DIGIT_LENGTH; i++) {
			if (playerInput.get(i).equals(this.randomGeneratedNumber.get(i))) {
				count += 1;
			}
		}
		this.strike = count;
	}

	private void countBall(List<Integer> playerInput) {
		int count = 0;
		for (int i = 0; i < Constants.DIGIT_LENGTH; i++) {
			if (this.randomGeneratedNumber.contains(playerInput.get(i))) {
				count += 1;
			}
		}
		this.ball = (count - this.strike);
	}
}
