package baseball;

import baseball.domain.BaseballGame;

public class Application {
	public static void main(String[] args) {
		// TODO: 숫자 야구 게임 구현
		BaseballGame baseballGame = new BaseballGame();
		BaseballGameController gameController = new BaseballGameController(baseballGame);

		int select = 0;
		do {
			gameController.gameStart();
			select = gameController.selectAfterEnd();
		} while (select == 1);
	}
}
