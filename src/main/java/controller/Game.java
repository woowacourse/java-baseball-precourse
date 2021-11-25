package controller;

import domain.Hint;
import domain.Numbers;
import domain.TargetNumbers;
import view.InputView;
import view.OutputView;

public class Game {

	private final TargetNumbers targetNumbers;

	public Game() {
		this.targetNumbers = new TargetNumbers();
	}

	private String getNumberInput() {
		OutputView.printInstruction();
		return InputView.getInput();
	}

	public void start() {
		while (true) {
			String userInput = getNumberInput();
			Numbers numbers = new Numbers(userInput);

			Hint hint = targetNumbers.compare(numbers);

			OutputView.printHint(hint);

			if (hint.getStrike() == 3)
				break;
		}
	}

}
