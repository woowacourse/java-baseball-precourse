package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	static String gameStatus;
	static ThreeDifferentDigits answer = new ThreeDifferentDigits();

	public static void main(String[] args) {
		gameStatus = "1";
		while (gameStatus.equals("1")) {
			Round.input3Digits(answer);
		}
	}

	static void continueGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		String input = Console.readLine();

		CheckException.isRightCommand(input);

		// 가능하면 종료되기 위해, 먼저 종료선언 함.
		gameStatus = "2";
		if (input.equals("1")) {
			newGame();
		}
	}

	static void newGame() {
		gameStatus = "1";
		answer = new ThreeDifferentDigits();
	}
}