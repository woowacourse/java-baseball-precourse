package controller;

import domain.Numbers;
import view.InputView;
import view.OutputView;

public class Game {

	private final Numbers targetNumbers;

	public Game() {
		this.targetNumbers = new Numbers();
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
