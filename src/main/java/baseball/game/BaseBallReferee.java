package baseball.game;

import java.util.List;

public class BaseBallReferee {

	private final int NUM_OF_DIGIT;

	public BaseBallReferee(int numOfDigit) {
		NUM_OF_DIGIT = numOfDigit;
	}

	public int getStrikeCount(List<Integer> randomNumbers, List<Integer> playerNumbers) {
		int numOfStrike = 0;
		for (int i = 0; i < NUM_OF_DIGIT; i++) {
			int randomNum = randomNumbers.get(i);
			int playerNum = playerNumbers.get(i);
			if (randomNum == playerNum) {
				numOfStrike += 1;
			}
		}
		return numOfStrike;
	}

	public int getBallCount(List<Integer> randomNumbers, List<Integer> playerNumbers) {
		int numOfBall = 0;
		for (int curPlayerIdx = 0; curPlayerIdx < NUM_OF_DIGIT; curPlayerIdx++) {
			int playerNum = playerNumbers.get(curPlayerIdx);
			if (sameNumWithoutCur(curPlayerIdx, playerNum, randomNumbers)) {
				numOfBall += 1;
			}
		}
		return numOfBall;
	}

	private boolean sameNumWithoutCur(int curPlayerIdx, int playerNum, List<Integer> randomNumbers) {
		for (int i = 0; i < NUM_OF_DIGIT; i++) {
			if (i == curPlayerIdx) {
				continue;
			}
			int randomNum = randomNumbers.get(i);

			if (randomNum == playerNum) {
				return true;
			}
		}
		return false;
	}
}
