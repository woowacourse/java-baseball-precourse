package baseball;

import java.util.List;

public class NumberComparator {
	private static final int NUMBER_LENGTH = 3;
	private List<Integer> computerNumbers;
	private List<Integer> playerNumbers;
	private int strikes;
	private int balls;

	public NumberComparator(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		this.computerNumbers = computerNumbers;
		this.playerNumbers = playerNumbers;
		this.strikes = 0;
		this.balls = 0;
	}

	public void compare() {
		for (int index = 0; index < NUMBER_LENGTH; index++) {
			if (!isStrike(index)) {
				isBall(index);
			}
		}
	}

	private boolean isBall(int index) {
		if (computerNumbers.contains(playerNumbers.get(index))) {
			balls++;
			return true;
		}
		return false;
	}

	private boolean isStrike(int index) {
		if (computerNumbers.get(index).equals(playerNumbers.get(index))) {
			strikes++;
			return true;
		}
		return false;
	}
}
