package controller;

import domain.Hint;
import domain.Numbers;
import domain.RestartOrQuitSelection;
import domain.TargetNumbers;
import view.InputView;
import view.OutputView;

public class Game {
	private TargetNumbers targetNumbers;

	private void createNewTargetNumbers() {
		this.targetNumbers = new TargetNumbers();
	}

	public void startGame() {
		while (true) {
			createNewTargetNumbers();
			startRound();

			RestartOrQuitSelection selection = InputView.inputRestart();
			if (selection.isQuit()) {
				break;
			}
		}
	}

	public void startRound() {
		while (true) {
			String userInput = InputView.inputNumbers();
			Numbers numbers = new Numbers(userInput);

			Hint hint = targetNumbers.compareTo(numbers);

			OutputView.printHint(hint);

			if (hint.getStrike() == 3) {
				break;
			}
		}
	}

}
