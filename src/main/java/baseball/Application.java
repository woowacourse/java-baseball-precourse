package baseball;

public class Application {
	public static void main(String[] args) {
		Game game = new Game();
		do {
			game.startGame();
			while (game.strike < 3) {
				game.play();
			}
		} while (!game.endsGame());
	}
}
