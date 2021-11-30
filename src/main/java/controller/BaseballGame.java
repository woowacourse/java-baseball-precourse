package controller;

import domain.AnswerNumbers;
import domain.BaseballNumbers;
import domain.CompareResult;
import domain.RestartOrEndSelection;
import view.InputView;
import view.OutputView;


public class BaseballGame {
	private AnswerNumbers answerNumbers;

	private void UpdateAnswerNumbers() {
		this.answerNumbers = new AnswerNumbers();
	}

	public void startGame() {
		do {
			UpdateAnswerNumbers();
			startRound();
		} while (checkRestart());
	}

	private void startRound() {
		while (true) {
			CompareResult compareResult = getRoundResult();
			OutputView.printRoundResult(compareResult);
			if (compareResult.isWin()) {
				break;
			}
		}
	}

	private boolean checkRestart() {
		RestartOrEndSelection selection = InputView.inputRestartOrEnd();
		return selection.isRestart();
	}

	private CompareResult getRoundResult() {
		BaseballNumbers baseballnumbers = InputView.inputBaseballNumbers();
		return this.answerNumbers.compareNumbers(baseballnumbers);
	}

}
