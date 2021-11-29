package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
	private static Target target = new Target();

	public static void main(String[] args) {
		int isGameEnd;
		do {
			gameStart();
			isGameEnd = Integer.parseInt(readLine());
		} while (isGameEnd == 1);
	}

	static void gameStart() {
		int[] ballsAndStrikes;
		do {
			System.out.print("숫자를 입력해주세요 : ");
			String userInput =  readLine();

			checkUserInput(userInput);
			ballsAndStrikes = target.compareWith(userInput);
			printResultOfInput(ballsAndStrikes);
		} while(ballsAndStrikes[Target.STRIKE] != 3);
	}

	static void checkUserInput(String userInput) {
		if (userInput.length() > target.getLength()) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < userInput.length(); i++) {
			System.out.println(userInput.charAt(i)-'0');
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
			System.out.println(ballsAndStrikes[Target.STRIKE] + "스트라이크");
		}
		System.out.println();
	}
}
