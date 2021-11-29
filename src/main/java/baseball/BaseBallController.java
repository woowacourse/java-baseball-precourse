package baseball;

public class BaseBallController {
	private Player player;
	private Referee referee = null;
	private BallGenerator ballGenerator = null;

	public BaseBallController(Player player) {
		this.player = player;
	}

	public void start() throws IllegalArgumentException {
		init();
		gameLogic();
	}

	private void init() {
		ballGenerator = new BallGenerator();
		BaseBallNumber computer = new BaseBallNumber(ballGenerator.createRandomBalls());
		referee = new Referee(computer);
	}

	private void gameLogic() {
		while (true) {
			String inputBallNumber = player.inputBallNumber();
			boolean isEnd = referee.isAllStrike(inputBallNumber);
			if (isEnd) {
				checkRestart();
				break;
			}
		}
	}

	private void checkRestart() {
		if (player.isRestart()) {
			start();
		}
	}
}
