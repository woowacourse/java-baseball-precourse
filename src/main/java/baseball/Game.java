package baseball;

public class Game {
	private static final int PROGRESS = 0;
	private static final int START = 1;
	private static final int TERMINATE = 2;
	
	private static final int ANSWER_COUNT = 3;
	
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
		this.gameNumber = new GameNumber();
	}

	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = new PlayerNumber(playerNumber);
	}

	public boolean isAnswer() {
		if (hint.getStrike() == ANSWER_COUNT) {
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
