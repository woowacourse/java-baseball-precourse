package baseball.view;

import static baseball.constants.GameConstants.Hint.*;

import baseball.domain.Game;

public class OutputView {
	public static void printInputHint() {
		System.out.print(HINT_ASK_INPUT.getString());
	}

	public static void printGameResult(Game game) {
		System.out.println(game);
	}
}
