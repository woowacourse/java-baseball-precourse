package baseball.game;

import baseball.input.RestartNumberInput;
import baseball.output.Output;
import baseball.output.PrintMessage;

public class BaseballGameManager {
	public void run() {
		do {
			BaseballGame baseballGame = new BaseballGame();
			baseballGame.playGame();
		} while (isRestartOption());

		Output.printBaseballGameResult(PrintMessage.PLAY_GAME_EXIT_MESSAGE.getMessage());
	}

	private boolean isRestartOption() {
		try {
			RestartNumberInput restartNumberInput = new RestartNumberInput();
			RestartOption restartOption = new RestartOption(restartNumberInput.receiveInput());
			return restartOption.isRestart();
		} catch (IllegalArgumentException e) {
			Output.printExceptionMessage(e.getMessage());
			return isRestartOption();
		}

	}

}
