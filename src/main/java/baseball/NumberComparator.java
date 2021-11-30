package baseball;

import java.util.List;

public class NumberComparator {
	private static final int NUMBER_LENGTH = 3;
	private static final int ZERO = 0;
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

	public void printResult() {
		if (balls != ZERO) {
			System.out.print(balls + "볼 ");
		}
		if (strikes != ZERO) {
			System.out.print(strikes + "스트라이크 ");
		}
		if (balls == ZERO && strikes == ZERO) {
			System.out.print("낫싱");
		}
		if (strikes == NUMBER_LENGTH) {
			System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
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
