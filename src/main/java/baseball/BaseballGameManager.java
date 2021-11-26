package baseball;

import com.io.Input;
import com.io.Output;

public class BaseballGameManager {
	public void run() {
		do {
			BaseballGame baseballGame = new BaseballGame();
			baseballGame.playGame();
		} while (isRestartOption());

		System.out.println(Output.PLAY_GAME_EXIT_MESSAGE);
	}

	private boolean isRestartOption() {
		try {
			RestartFlag restartFlag = new RestartFlag(Input.receiveRestartInput());
			return restartFlag.isRestart();
		} catch (IllegalArgumentException e) {
			Output.printExceptionMessage(e.getMessage());
			return isRestartOption();
		}

	}

}
