package baseball;

public class Game {
	private final static int PROGRESS = 0;
	private final static int START = 1;
	private final static int TERMINATE = 2;

	private int status;
	private GameNumber gameNumber;
	private PlayerNumber playerNumber;
	private Hint hint;

	public Game() {
		status = START;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setGameNumber() {
		gameNumber = new GameNumber();
	}

	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = new PlayerNumber(playerNumber);
	}

	public boolean isAnswer() {
		if (hint.getStrike() == 3) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTerminate() {
		if (status == TERMINATE) {
			return true;
		} else {
			return false;
		}
	}

	public void generateHint() {
		hint = new Hint(gameNumber, playerNumber);
		hint.countStrikeAndBall();
	}

	public void run(String playerNumber) {
		if (status == START) {
			setGameNumber();
			setStatus(PROGRESS);
		}
		setPlayerNumber(playerNumber);
		generateHint();
		hint.printHint();
	}
}
