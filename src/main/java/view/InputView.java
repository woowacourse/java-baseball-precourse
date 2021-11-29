package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Numbers;
import domain.RestartOrQuitSelection;

public class InputView {
	public static Numbers inputNumbers() {
		OutputView.printInstruction();
		String input = Console.readLine();
		return new Numbers(input);
	}

	public static RestartOrQuitSelection inputRestart() {
		OutputView.printQuitInstruction();
		String input = Console.readLine();
		return new RestartOrQuitSelection(input);
	}

}
