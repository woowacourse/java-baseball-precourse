package baseball;

import java.util.HashSet;

public class Hint {
	private static final int NUMBER_OF_DIGIT = 3;

	private int strike;
	private int ball;
	private String gameNumber;
	private String playerNumber;

	public Hint(GameNumber gameNumber, PlayerNumber playerNumber) {
		this.gameNumber = gameNumber.getGameNumber();
		this.playerNumber = playerNumber.getPlayerNumber();
	}

	public void countStrikeAndBall() {
		countStrike();
		countBall();
	}

	public void countStrike() {
		for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
			if (gameNumber.charAt(i) == playerNumber.charAt(i)) {
				strike++;
			}
		}
	}

	public void countBall() {
		HashSet<Character> digits = new HashSet<Character>();
		for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
			digits.add(gameNumber.charAt(i));
			digits.add(playerNumber.charAt(i));
		}
		ball = NUMBER_OF_DIGIT * 2 - digits.size() - strike;
	}

	public void printHint() {
		if (ball == 0 && strike == 0) {
			System.out.print("낫싱");
		}
		if (ball != 0) {
			System.out.print(ball + "볼 ");
		}
		if (strike != 0) {
			System.out.print(strike + "스트라이크 ");
		}
		System.out.println();
		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}

	public int getStrike() {
		return strike;
	}
}