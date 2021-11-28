package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private final int ANSWER_SIZE = 3;
	private int strike = 0;
	private int ball = 0;
	public Computer com = new Computer();
	public User user = new User();

	public boolean playGame() {
		com.makeAnswer();
		while (strike != ANSWER_SIZE) {
			user.chooseNumber();
			strike = countStrike();
			ball = countBall();
			printResult();
		}
		return restart();
	}

	public int countStrike() {
		int cnt_strike = 0;

		for (int i = 0; i < ANSWER_SIZE; i++) {
			if (checkStrike(i)) {
				cnt_strike++;
			}
		}
		return cnt_strike;
	}

	public boolean checkStrike(int idx) {
		if (com.answer[idx] == user.number[idx]) {
			return true;
		} else {
			return false;
		}
	}

	public int countBall() {
		int cnt_ball = 0;
		for (int i = 0; i < ANSWER_SIZE; i++) {
			if (checkBall(i)) {
				cnt_ball++;
			}
		}
		return cnt_ball;
	}

	public boolean checkBall(int idx) {
		for (int i = 0; i < ANSWER_SIZE; i++) {
			if (i != idx && user.number[idx] == com.answer[i]) {
				return true;
			}
		}
		return false;
	}

	public void printResult() {
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
		} else if (strike == ANSWER_SIZE) {
			System.out.println(strike + "스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셧습니다! 게임 종료");
		} else if (strike == 0) {
			System.out.println(ball + "볼");
		} else if (ball == 0) {
			System.out.println(strike + "스트라이크");
		} else {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		}
	}

	public boolean restart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String str = Console.readLine();

		if (str.equals("1")) {
			return true;
		} else {
			return false;
		}
	}
}
