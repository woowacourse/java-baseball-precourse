package baseball;

public class Game {
	private int strike = 0;
	private int ball = 0;
	public Computer com = new Computer();
	public User user = new User();

	public boolean playGame() {
		com.makeAnswer();
		while (strike != 3) {
			user.chooseNumber();
			strike = countStrike();
			ball = countBall();
			printResult();
		}
		return restart();
	}

	public int countStrike() {
		int cnt_strike = 0;

		for (int i = 0; i < 3; i++) {
			if (com.answer[i] == user.number[i]) {
				cnt_strike++;
			}
		}
		return cnt_strike;
	}

	public int countBall() {
	}

	public void printResult() {
	}

	public boolean restart() {
	}
}
