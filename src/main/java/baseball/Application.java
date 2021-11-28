package baseball;

public class Application {
	public static void main(String[] args) {
		boolean restartGame = true;
		while (restartGame) {
			Game game = new Game();
			restartGame = game.playGame();
		}
		//TODO: 숫자 야구 게임 구현
	}
}
