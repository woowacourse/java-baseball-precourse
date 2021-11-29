package baseball;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		boolean gameOnProgress;
		Baseball baseball = new Baseball();
		do {
			gameOnProgress = baseball.runGame();
		} while (gameOnProgress);
	}
}
