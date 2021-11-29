package baseball;

public class Application {
	public static void main(String[] args) {
		Player player = new Player();
		BaseBallController game = new BaseBallController(player);
		game.start();
	}
}
