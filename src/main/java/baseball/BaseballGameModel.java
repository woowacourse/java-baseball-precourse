package baseball;

import static util.Constants.*;

import java.util.stream.IntStream;

class BaseballGameModel {
	public static BaseballGameModel baseballGameModel = new BaseballGameModel();

	private BaseballGameModel() {
	}

	public static BaseballGameModel getBaseballGameModel() {
		return baseballGameModel;
	}

	public boolean checkResult(int strikeCount) {
		if (strikeCount == 3) {
			return true;
		}
		return false;
	}

	public int getBall(int[] playerNum, int[] enemyNum) {
		int ballCount = 0;
		for (Integer num : playerNum) {
			if (IntStream.of(enemyNum).anyMatch(x -> x == num)) {
				ballCount++;
			}
		}
		return ballCount;
	}

	public int getStrike(int[] playerNum, int[] enemyNum) {
		int strikeCount = 0;
		for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
			if (playerNum[i] == enemyNum[i]) {
				strikeCount++;
				playerNum[i] = -1;
			}
		}
		return strikeCount;
	}

}
