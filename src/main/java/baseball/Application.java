package baseball;

import camp.nextstep.edu.missionutils.Console;
import random.Random;

public class Application {

	public static void main(String[] args) {

		do {

			String answer = Random.createAnswer();

			proceed(answer);

			System.out.println(Message.CLEAR);

			System.out.println(Message.RESTART_OR_EXIT);

		} while (selectRestartOrExit());

	}

	private static void proceed(String answer) {

		String resultMessage;

		do {

			System.out.print(Message.QUESTION);

			String input = Console.readLine();

			Verification.ofInput(input);

			resultMessage = Game.play(answer, input);

			System.out.println(resultMessage);

		} while (!resultMessage.equals(3 + Message.STRIKE));
	}

	private static boolean selectRestartOrExit() {

		String reStartOrExitInput = Console.readLine();

		int restartOrExit = Verification.ofReStartOrExitInput(reStartOrExitInput);

		if (restartOrExit == 1) {
			return true;
		}

		return false;
	}
}
