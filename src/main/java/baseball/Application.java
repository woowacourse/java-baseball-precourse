package baseball;

import baseball.computer.Computer;
import baseball.game.Game;
import baseball.user.User;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		Game game = new Game(new Computer(), new User());
		game.start();
	}
}
