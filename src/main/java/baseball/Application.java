package baseball;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		while (true) {
			BaseballGame baseballGame = new BaseballGame();
			baseballGame.playGame();
			if (baseballGame.isQuit()) {
				break;
			}
		}
	}
}
