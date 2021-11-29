package baseball;

import java.util.ArrayList;

import baseball.view.InputView;

public class Baseball {
	public static boolean runGame() {
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

	public static boolean gameRestartOrNot() {
		InputView.printGameRestartMessage();
		return InputView.inputGameRestartOrNot();
	}
}
