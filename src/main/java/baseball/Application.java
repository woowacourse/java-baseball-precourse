package baseball;

public class Application {

	public static void main(String[] args) {
		while (true) {
			boolean reStartBaseballGame = BaseballGame.play();
			if (!reStartBaseballGame) {
				break;
			}
		}
	}
}
