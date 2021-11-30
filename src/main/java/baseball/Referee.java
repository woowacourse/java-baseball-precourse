package baseball;

import java.util.Arrays;

public class Referee {
	private int strike;
	private int ball;

	void judge(String[] answer, String[] input) {
		countBallStrike(answer, input);

		printResult();
	}

	void countBallStrike(String[] s1, String[] s2) {
		strike = 0;
		ball = 0;

		for (int i = 0; i < 3; i++) {
			if (s1[i].equals(s2[i])) {
				strike++;
			} else if (Arrays.toString(s1).contains(s2[i])) {
				ball++;
			}
		}
	}

	void printResult() {
		if (ball != 0) {
			printBall();
		} else if (strike != 0) {
			printStrike();
		} else if (strike == 0 && ball == 0) {
			printNothing();
		}
	}

	void printBall() {
		System.out.printf("%s볼", ball);

		if (strike != 0) {
			System.out.printf(" %s스트라이크", strike);
		}

		System.out.println();
	}

	void printStrike() {
		System.out.printf("%s스트라이크", strike);
		System.out.println();

		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			Application.continueGame();
		}
	}

	void printNothing() {
		System.out.println("낫싱");
	}
}