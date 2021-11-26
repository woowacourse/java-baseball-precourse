package baseball;

import java.util.ArrayList;

public class GamePlay {

	public static void runGame() {
		ArrayList<Integer> randomNumbers = RandomNumber.getRandomNumbers();
		while (true) {
			UserInterfaceView.printNumberInputMessage();
			ArrayList<Integer> userInputNumbers = UserInterfaceView.inputUserNumbers();
			Hint.getHint(randomNumbers, userInputNumbers);
			if (Hint.strike == RandomNumber.PICK_NUMBER) {
				gameRestartOrNot();
				break;
			}
		}
	}

	public static void gameRestartOrNot() {
		UserInterfaceView.printGameRestartMessage();
		if (UserInterfaceView.inputGameRestartOrNot() == 1) {
			runGame();
		}
	}
}
