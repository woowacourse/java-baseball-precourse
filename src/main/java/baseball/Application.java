package baseball;

import baseball.domain.game.Game;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		AppConfig config = new AppConfig();
		Application app = new Application();
		Game game = config.getNumberBaseballGame();
		app.run(game);
	}

	public void run(Game game) {
		game.run();
	}
}
