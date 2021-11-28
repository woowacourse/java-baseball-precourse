package baseball;

public class Application {

	public static void main(String[] args) {

		// GameHost 객체를 통해 숫자야구 게임을 진행한다.
		GameHost gameHost = new GameHost();
		gameHost.runGame();
	}
}
