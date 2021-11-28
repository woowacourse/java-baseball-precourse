package baseball;

import static baseball.game.constants.BaseballGameConstants.*;

import baseball.game.BaseballGame;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		while (true) {
			BaseballGame newGame = new BaseballGame();
			if (newGame.start() == GAMEOVER) {
				break;
			}
		}
	}
}
