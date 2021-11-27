package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

	public Player() {
	}

	public void takePlayerNum(int[] playerNum) {
		char charPlayerNum;
		System.out.print(INPUT_MESSAGE);
		String userInput = Console.readLine();
		if (userInput.length() != 3) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < 3; i++) {
			charPlayerNum = userInput.charAt(i);
			if (!Character.isDigit(charPlayerNum)) {
				throw new IllegalArgumentException();
			}
			playerNum[i] = Character.getNumericValue(charPlayerNum);
		}
	}
}
