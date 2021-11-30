package view;

import camp.nextstep.edu.missionutils.Console;
import domain.BaseballNumbers;
import domain.RestartOrEndSelection;

public class InputView {
	public static BaseballNumbers inputBaseballNumbers() {
		OutputView.printInputRequest();
		String input = Console.readLine();
		return new BaseballNumbers(input);
	}

	public static RestartOrEndSelection inputRestartOrEnd() {
		OutputView.printRestartOrEnd();
		String input = Console.readLine();
		return new RestartOrEndSelection(input);
	}

}
