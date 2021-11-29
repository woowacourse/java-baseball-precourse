package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
	private static final String ASK_GUESS_MESSAGE = "숫자를 입력해주세요 : ";

	public GameView() {
	}

	public String askGuess() {
		System.out.print(ASK_GUESS_MESSAGE);
		String input = Console.readLine();
		return input;
	}

}
