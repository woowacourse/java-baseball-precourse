package baseball;

public class Application {
	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		do {
			baseballGame.play();
		} while (baseballGame.checkRestart());
	}
}
