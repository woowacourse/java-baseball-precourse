package baseball;

import baseball.game.BaseballGameManager;

public class Application {
	public static void main(String[] args) {
		BaseballGameManager baseballGameManager = new BaseballGameManager();
		baseballGameManager.run();
	}

}
