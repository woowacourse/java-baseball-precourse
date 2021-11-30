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
		while (this.randomGeneratedNumber.size() < 3) {
			int digit = Randoms.pickNumberInRange(1, 9);
			if (!this.randomGeneratedNumber.contains(digit)) {
				this.randomGeneratedNumber.add(digit);
			}
		}
	}

	public boolean isGameOver() {
		return this.strike == 3;
	}

	public void printScore() {
		if (this.strike == 0 && this.ball == 0) {
			System.out.println("낫싱");
		} else if (this.strike != 0 && this.ball == 0) {
			System.out.println(this.strike + "스트라이크");
			if (this.strike == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			}
		} else if (this.strike == 0) {
			System.out.println(this.ball + "볼");
		} else {
			System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
		}
	}

	public void countScore(List<Integer> playerInput) {
		countStrike(playerInput);
		countBall(playerInput);
	}

	private void countStrike(List<Integer> playerInput) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (playerInput.get(i).equals(this.randomGeneratedNumber.get(i))) {
				count += 1;
			}
		}
		this.strike = count;
	}

	private void countBall(List<Integer> playerInput) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (this.randomGeneratedNumber.contains(playerInput.get(i))) {
				count += 1;
			}
		}
		this.ball = (count - this.strike);
	}
}
