package baseball;

import java.util.ArrayList;

import baseball.view.InputView;

public class GamePlay {

	public static void runGame() {
		ArrayList<Integer> randomNumbers = RandomNumber.getRandomNumbers();
		while (true) {
			InputView.printNumberInputMessage();
			ArrayList<Integer> userInputNumbers = InputView.inputUserNumbers();
			Hint.getHint(randomNumbers, userInputNumbers);
			if (Hint.strike == RandomNumber.PICK_NUMBER) {
				gameRestartOrNot();
				break;
			}
		}
	}

	public static void gameRestartOrNot() {
		InputView.printGameRestartMessage();
		if (InputView.inputGameRestartOrNot() == 1) {
			runGame();
		}
	}
}
