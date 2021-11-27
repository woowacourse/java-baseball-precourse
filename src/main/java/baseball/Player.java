package baseball;

import static util.Constants.*;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private static final Player player = new Player();

	private Player() {
	}

	public static Player getPlayer() {
		return player;
	}

	public void takePlayerNum(int[] playerNum) {
		char charPlayerNum;
		System.out.print(INPUT_MESSAGE);
		String userInput = Console.readLine();
		if (userInput.length() != GAME_NUMBER_LENGTH) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
			charPlayerNum = userInput.charAt(i);
			if (!Character.isDigit(charPlayerNum)) {
				throw new IllegalArgumentException();
			}
			playerNum[i] = Character.getNumericValue(charPlayerNum);
		}
	}
}
