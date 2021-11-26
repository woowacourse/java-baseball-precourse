package baseball;

public class Application {

	public static void main(String[] args) {
		while (true) {
			boolean finishBaseballGame = BaseballGame.play();
			if (finishBaseballGame) {
				break;
			}
		}
	}
}
