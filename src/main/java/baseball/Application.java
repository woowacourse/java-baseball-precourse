package baseball;

import camp.nextstep.edu.missionutils.Console;
import static constant.Constant.*;
import random.Random;

public class Application {

	public static void main(String[] args) {

		do {

			String answer = Random.createAnswer();

			proceed(answer);

			System.out.println(CLEAR);

			System.out.println(RESTART_OR_EXIT);

		} while (selectRestartOrExit());

	}

	private static void proceed(String answer) {

		String resultMessage;

		do {

			System.out.print(QUESTION);

			String input = Console.readLine();

			Verification.ofInput(input);

			resultMessage = Game.play(answer, input);

			System.out.println(resultMessage);

		} while (!resultMessage.equals(INPUT_LENGTH + STRIKE));
	}

	private static boolean selectRestartOrExit() {

		String reStartOrExitInput = Console.readLine();

		Verification.ofReStartOrExitInput(reStartOrExitInput);

		if (reStartOrExitInput.equals(RE_START)) {
			return true;
		}

		return false;
	}
}
