package baseball;

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
		int ball = 0;
		for (Integer num : playerNum) {
			if (IntStream.of(enemyNum).anyMatch(x -> x == num)) {
				ball++;
			}
		}
		return ball;
	}

	public int getStrike(int[] playerNum, int[] enemyNum) {
		int strike = 0;
		for (int i = 0; i < 3; i++) {
			if (playerNum[i] == enemyNum[i]) {
				strike++;
				playerNum[i] = -1;
			}
		}
		return strike;
	}

}
