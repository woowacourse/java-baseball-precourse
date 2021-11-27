package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static String randomNumber;
	private static String inputNumber;
	private static int strike;
	private static int ball;

	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
	}

	public static String createRandomNumber() {
		String randomNumber = "";
		while (randomNumber.length() < 3) {
			String num = String.valueOf(Randoms.pickNumberInRange(1, 10));
			if (!randomNumber.contains(num)) {
				randomNumber += num;
			}
		}
		return randomNumber;
	}

	public static int countStrike() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (randomNumber.charAt(i) == inputNumber.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	public static int countBall() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (randomNumber.contains(inputNumber.substring(i, i+1)) && randomNumber.charAt(i) != inputNumber.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	public static void printBallAndStrikeCount() {
		ball = countBall();
		strike = countStrike();
		if (ball > 0) {
			System.out.print(ball + "볼 ");
		}
		if (strike > 0) {
			System.out.print(strike + "스트라이크 ");
		}
		if (ball == 0 && strike == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
	}
}
