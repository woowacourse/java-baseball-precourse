package baseball;

public class BaseBallController {
	private Player player;
	private Referee referee = null;
	private BallGenerator ballGenerator = null;

	public BaseBallController(Player player) {
		this.player = player;
	}

	public void start() throws IllegalArgumentException {
		ballGenerator = new BallGenerator();
		String computer = ballGenerator.createRandomBalls();
		referee = new Referee(computer);
		while (true) {
			String inputBallNumber = player.inputBallNumber();
			boolean isEnd = referee.isAllStrike(inputBallNumber);
			if (isEnd) {
				if (player.isRestart()) {
					start();
				}
			}
		}
	}
}
