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
		do {
			createNewTargetNumbers();
			startRound();
		} while (checkRestart());
	}

	private void startRound() {
		while (true) {
			PredictionResult predictionResult = getPrediction();
			OutputView.printHint(predictionResult);

			if (predictionResult.isWin()) {
				break;
			}
		}
	}

	private boolean checkRestart() {
		RestartOrQuitSelection selection = InputView.inputRestart();
		return selection.isRestart();
	}

	private PredictionResult getPrediction() {
		Numbers numbers = InputView.inputNumbers();
		return this.targetNumbers.compareTo(numbers);
	}

}
