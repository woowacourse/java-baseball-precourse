package controller;

import domain.Hint;
import domain.Numbers;
import domain.TargetNumbers;
import view.InputView;
import view.OutputView;

public class Game {

	private static final String RESTART_INPUT = "1";
	private static final String QUIT_INPUT = "2";

	private final TargetNumbers targetNumbers;

	public Game() {
		this.targetNumbers = new TargetNumbers();
	}

	private String getNumberInput() {
		OutputView.printInstruction();
		return InputView.getInput();
	}

	private boolean getQuitInput() {
		OutputView.printQuitInstruction();
		String input = InputView.getInput();

		if (input.equals(QUIT_INPUT))
			return true;
		if (input.equals(RESTART_INPUT))
			return false;

		throw new IllegalArgumentException("1 또는 2 만 입력할 수 있습니다.");
	}

	public void start() {
		while (true) {
			boolean isGameEnd = play();
			if (isGameEnd)
				break;
		}
	}

	public boolean play() {
		String userInput = getNumberInput();
		Numbers numbers = new Numbers(userInput);

		Hint hint = targetNumbers.compare(numbers);

		OutputView.printHint(hint);

		if (hint.getStrike() == 3)
			return getQuitInput();

		return false;
	}

}
