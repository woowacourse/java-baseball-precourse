package controller;

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
		String userInput = getNumberInput();
		Numbers numbers = new Numbers(userInput);
	}

}
