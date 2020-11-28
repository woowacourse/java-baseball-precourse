package baseball;

import java.util.Scanner;
import java.util.HashMap;

public class Player {
	Scanner scanner = new Scanner(System.in);
	StringGameGuide guide = new StringGameGuide();
	HashMap<Integer, Integer> playerNumbersMap = new HashMap<Integer, Integer>();
	final int MAX_PLAYER_KEY_NUMBERS = 3;

	private int[] inputThreeNumbers() {
		int inputNumbers = scanner.nextInt();
		int[] arrayNumbers = new int[MAX_PLAYER_KEY_NUMBERS];
		for (int num = 0; num < MAX_PLAYER_KEY_NUMBERS; num++) {
			while (num > 0) {
				arrayNumbers[num] += inputNumbers % 10;
				inputNumbers /= 10;
			}
		}
		return arrayNumbers;
	}

	public HashMap<Integer, Integer> duplicateThreeNumbers() {
		System.out.println(guide.InputNumbers());
		final int[] playerThreeNumbersArray = inputThreeNumbers();
		for (int num = 0; num <= MAX_PLAYER_KEY_NUMBERS; num++) {
			playerNumbersMap.put(num, playerThreeNumbersArray[num]);
		}
		return playerNumbersMap;
	}

}
