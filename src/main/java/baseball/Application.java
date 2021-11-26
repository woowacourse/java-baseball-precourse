package baseball;

import static constant.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import random.Random;

public class Application {

	public static void main(String[] args) {

		do {

			Controller controller = new Controller(Random.createAnswer());
			controller.start();

		} while (selectRestartOrExit());
	}

	private static boolean selectRestartOrExit() {

		System.out.println(RESTART_OR_EXIT);

		String reStartOrExitInput = Console.readLine();

		Verification.ofReStartOrExitInput(reStartOrExitInput);

		if (reStartOrExitInput.equals(RE_START)) {
			return true;
		}

		return false;
	}
}
