package baseball;

import utils.RandomUtils;

public class GameNumber {
	private static final int NUMBER_OF_DIGIT = 3;
	private static final int RANGE_MINIMUM = 1;
	private static final int RANGE_MAXIMUM = 9;

	private String gameNumber;

	public GameNumber() {
		gameNumber = "";
		while (gameNumber.length() < NUMBER_OF_DIGIT) {
			int digit = RandomUtils.nextInt(RANGE_MINIMUM, RANGE_MAXIMUM);
			if (!gameNumber.contains(Integer.toString(digit))) {
				gameNumber += digit;
			}
		}
	}

	public String getGameNumber() {
		return gameNumber;
	}
}