package controller;

import domain.Numbers;
import domain.PredictionResult;
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
			Numbers numbers = InputView.inputNumbers();

			PredictionResult predictionResult = targetNumbers.compareTo(numbers);

			OutputView.printHint(predictionResult);

			if (predictionResult.isWin()) {
				break;
			}
		}
	}

}
