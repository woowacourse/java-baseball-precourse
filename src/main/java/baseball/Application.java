package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
	private static Target target = new Target();

	public static void main(String[] args) {
		do {
			gameStart();
		} while (checkRestart());
	}

	static void gameStart() {
		target.generateTargetNumber();
		int[] ballsAndStrikes;

		do {
			System.out.print("숫자를 입력해주세요 : ");
			String userInput = readLine();
			checkUserInput(userInput);

			ballsAndStrikes = target.compareWith(userInput);
			printResultOfInput(ballsAndStrikes);
		} while (ballsAndStrikes[Target.STRIKE] != 3);

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	static void checkUserInput(String userInput) {
		if (userInput.length() != target.getLength()) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < userInput.length(); i++) {
			if (userInput.charAt(i) - '0' < target.getRangeBegin() ||
				userInput.charAt(i) - '0' > target.getRangeEnd()) {
				throw new IllegalArgumentException();
			}
		}
	}

	static void printResultOfInput(int[] ballsAndStrikes) {
		if (ballsAndStrikes[Target.BALL] > 0) {
			System.out.print(ballsAndStrikes[Target.BALL] + "볼 ");
		}
		if (ballsAndStrikes[Target.STRIKE] > 0) {
			System.out.print(ballsAndStrikes[Target.STRIKE] + "스트라이크");
		}
		if (ballsAndStrikes[Target.BALL] == 0 && ballsAndStrikes[Target.STRIKE] == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
	}

	static boolean checkRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String userInput = readLine();
		if (userInput.equals("1")) {
			return true;
		} else if (userInput.equals("2")) {
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
