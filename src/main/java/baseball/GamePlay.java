package baseball;

import java.util.HashMap;

public class GamePlay {

	public static void playGame() {
		int[] randomNumbers = RandomNumber.getRandomNumbers();
		View.printNumberInputMessage();
		int[] userInputNumbers = View.inputUserNumbers();
		HashMap<String, Integer> hintMap = Hint.getHint(randomNumbers, userInputNumbers);
		View.printHint(hintMap);
	}
}
