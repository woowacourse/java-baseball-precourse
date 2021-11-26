package baseball;


public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현

		Game game = new Game();
		GameReply gameReply = new GameReply();
		Result result = new Result();

		boolean continueGame = true;
		while (continueGame) {
			game.start();
			gameReply.askReply();
			result.matchAnswer(game.getAnswer(), gameReply.getGameReply());
			result.printResult();

			continueGame = game.afterGame();
		}
	}
}
