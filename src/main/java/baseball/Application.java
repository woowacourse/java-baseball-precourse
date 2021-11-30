package baseball;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		Player player = new Player();
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.runBaseballGame(player);
	}
}
