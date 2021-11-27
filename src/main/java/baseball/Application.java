package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static String randomNumber;
	private static String inputNumber;
	private static int strike;
	private static int ball;
	private static boolean isThreeStrike;
	private static boolean isFinished;
	private static String checkRestartOrFinished;

	private static final String RESTART = "1";
	private static final String END = "2";

	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		randomNumber = createRandomNumber();
		while (!isFinished) {
			while (!isThreeStrike) {
				System.out.println("숫자를 입력해주세요 : ");
				inputNumber = Console.readLine();
				isRightThreeDigitsNumber();
				printBallAndStrikeCount();
				isThreeStrike();
			}
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			checkRestartOrFinished = Console.readLine();
			isRightRestartOrFinishedNumber();
			isFinished();
		}
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

	public static void isThreeStrike() {
		if (strike == 3) {
			isThreeStrike = true;
		}
	}

	public static void isFinished() {
		if (checkRestartOrFinished.equals(END)) {
			isFinished = true;
		}
	}

	public static void isRightThreeDigitsNumber() {
		if (inputNumber.length() != 3) {
			throw new IllegalArgumentException();
		}
	}

	public static void isRightRestartOrFinishedNumber() {
		if (!(checkRestartOrFinished.equals(RESTART) || checkRestartOrFinished.equals(END))) {
			throw new IllegalArgumentException();
		}
	}
}
