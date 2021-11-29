package baseball.domain;

import java.util.ArrayList;

import baseball.view.InputView;

public class Game {
	public void run() {
		boolean gameOnProgress;
		do {
			gameOnProgress = playGame();
		} while (gameOnProgress);
	}

	public boolean playGame() {
		ArrayList<Integer> randomNumbers = RandomNumber.getRandomNumbers();
		while (true) {
			InputView.printNumberInputMessage();
			ArrayList<Integer> userInputNumbers = InputView.inputUserNumbers();
			Hint.getHint(randomNumbers, userInputNumbers);
			if (Hint.strike == RandomNumber.PICK_NUMBER) {
				return gameRestartOrNot();
			}
		}
	}

	public boolean gameRestartOrNot() {
		InputView.printGameRestartMessage();
		return InputView.inputGameRestartOrNot();
	}
}
