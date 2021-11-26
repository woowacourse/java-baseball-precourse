package baseball;

import baseball.constant.BaseballConst;
import baseball.controller.BaseballGameController;
import baseball.domain.BaseballGame;

public class Application {
	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		BaseballGameController gameController = new BaseballGameController(baseballGame);

		do {
			gameController.gameStart();
		} while (gameController.selectAfterEnd() == BaseballConst.RETRY);
	}
}
