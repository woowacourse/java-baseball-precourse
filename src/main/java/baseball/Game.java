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
		int cnt_ball = 0;
		for (int i = 0; i < 3; i++) {
			if (checkBall(i)) {
				cnt_ball++;
			}
		}
		return cnt_ball;
	}

	public boolean checkBall(int idx) {
		for (int i = 0; i < 3; i++) {
			if (i != idx && user.number[idx] == com.answer[i]) {
				return true;
			}
		}
		return false;
	}

	public void printResult() {
	}

	public boolean restart() {
	}
}
