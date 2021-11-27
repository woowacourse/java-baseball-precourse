package baseball.controller;

import baseball.domain.BaseballGame;

public class BaseballGameController {

	private BaseballGame baseballGame;

	public BaseballGameController() {
		baseballGame = new BaseballGame();
	}

	public void run() {
		do {
			baseballGame.generateAnswerNumbers();
			baseballGame.startBaseballGame();
		} while (baseballGame.isRestart());
	}
}
