package baseball;

import camp.nextstep.edu.missionutils.Console;
import random.Random;

public class Application {

	public static void main(String[] args) {

		do {

			String answer = Random.createAnswer();

			proceed(answer);

			System.out.println(Message.RESTART_OR_EXIT);

		} while (selectRestartOrExit());

	}

	private static void proceed(String answer) {

		while (true) {

			System.out.print(Message.QUESTION);

			String input = Console.readLine();

			verifyInput(input);

			String resultMessage = Game.play(answer, input);

			System.out.println(resultMessage);

			if (resultMessage.equals(3 + Message.STRIKE)) {

				System.out.println(Message.CLEAR);

				break;
			}
		}
	}

	private static boolean selectRestartOrExit() {

		String reStartOrExitInput = Console.readLine();

		int restartOrExit = verifyReStartOrExitInput(reStartOrExitInput);

		if (restartOrExit == 1) {
			return true;
		}

		return false;
	}

	static int verifyReStartOrExitInput(String input) {

		int integerInput = isInteger(input);

		if (integerInput != 1 && integerInput != 2) {
			throw new IllegalArgumentException("1과 2 중에서 선택해야 합니다.");
		}

		return integerInput;
	}

	static void verifyInput(String input) {

		isInteger(input);

		if (input.length() != 3) {
			throw new IllegalArgumentException("세 자리 수를 입력해야 합니다.");
		}
	}

	private static int isInteger(String input) {

		if (!input.matches("-?\\d+")) {
			throw new IllegalArgumentException("정수를 입력해야 합니다.");
		}

		return Integer.parseInt(input);
	}
}
