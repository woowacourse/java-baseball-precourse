package baseball;

import baseball.domain.game.NumberBaseballGame;
import baseball.view.ConsoleView;
import baseball.view.View;

public class AppConfig {

	public static final int RADIX = 10;

	public NumberBaseballGame getNumberBaseballGame() {
		return new NumberBaseballGame(getConsoleView());
	}

	private View getConsoleView() {
		return new ConsoleView();
	}
}
