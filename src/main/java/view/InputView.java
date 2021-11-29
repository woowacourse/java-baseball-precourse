package view;

import camp.nextstep.edu.missionutils.Console;
import domain.RestartOrQuitSelection;

public class InputView {
	public static String inputNumbers() {
		OutputView.printInstruction();
		return Console.readLine();
	}

	public static RestartOrQuitSelection inputRestart() {
		OutputView.printQuitInstruction();
		String input = Console.readLine();
		return new RestartOrQuitSelection(input);
	}

}
