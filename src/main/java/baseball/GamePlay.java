package baseball;

import java.util.HashMap;

public class GamePlay {

	public static void playGame() {
		int[] randomNumbers = RandomNumber.getRandomNumbers();
		while (true) {
			View.printNumberInputMessage();
			int[] userInputNumbers = View.inputUserNumbers();
			HashMap<String, Integer> hintMap = Hint.getHint(randomNumbers, userInputNumbers);
			View.printHint(hintMap);
			if (hintMap.get("strike") == 3) {
				gameRestartOrNot();
				break;
			}
		}
	}

	public static void gameRestartOrNot() {
		View.printGameRestartMessage();
		if (View.inputGameRestartOrNot() == 1) {
			playGame();
		}
	}
}
