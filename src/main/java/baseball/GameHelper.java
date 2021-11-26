package baseball;

import java.util.ArrayList;

public class GameHelper {
	private int strike;
	private int ball;

	public GameHelper() {
		this.strike = 0;
		this.ball = 0;
	}

	public boolean judgement(ArrayList<Integer> randomNumber, ArrayList<Integer> playerNumber) {
		count_Strike(randomNumber, playerNumber);
		count_Ball(randomNumber, playerNumber);

		if (this.strike == 3) {
			System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		if (this.strike != 0 && this.ball != 0)
			System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
		else if (this.strike == 0 && this.ball != 0)
			System.out.println(this.ball + "볼");
		else if (this.strike != 0 && this.ball == 0)
			System.out.println(this.strike + "스트라이크");
		else {
			System.out.println("낫싱");
		}
		return false;
	}

	public int count_Strike(ArrayList<Integer> randomNumber, ArrayList<Integer> playerNumber) {
		for (int i = 0; i < 3; i++) {
			this.strike += is_equals(randomNumber.get(i), playerNumber.get(i));
		}
		return this.strike;
	}

	public int count_Ball(ArrayList<Integer> randomNumber, ArrayList<Integer> playerNumber) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.ball += is_equals(randomNumber.get(i), playerNumber.get(j));
			}
		}
		this.ball -= this.strike;
		return this.ball;
	}

	public int is_equals(int randomNumber, int playerNumber) {
		if (randomNumber == playerNumber)
			return 1;
		return 0;
	}
}
