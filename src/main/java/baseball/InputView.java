package baseball;

import static utils.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getInputNumber() {
		System.out.print(INPUT_REQUEST);
		String input = Console.readLine();
		return input;
	}

	public static String getRestartOrFinishCommand() {
		System.out.println(RESTART_OR_FINISH_REQUEST);
		String input = Console.readLine();
		return input;
	}
}
