package baseball;

import baseball.constant.BaseballConst;
import baseball.controller.BaseballGameController;
import baseball.domain.BaseballGame;

public class Application {
	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		BaseballGameController gameController = new BaseballGameController(baseballGame);

		int select = 0;
		do {
			gameController.gameStart();
			select = gameController.selectAfterEnd();
		} while (select == BaseballConst.RETRY);
	}
}
