package baseball.domain;

public class GameResult {

	private static final int END = 3;
	private static final int NONE = 0;
	private static final String BALL_HINT = "볼";
	private static final String STRIKE_HINT = "스트라이크";
	private static final String ZERO_HINT = "낫싱";

	private Computer computer;
	private UserInput userInput;
	private long strikeScore;
	private long ballScore;

	public GameResult(Computer computer, UserInput userInput) {
		this.computer = computer;
		this.userInput = userInput;

		setResult();
	}

	public boolean compareNumber() {
		return strikeScore != END;
	}

	public void setResult() {
		long containsNumber = userInput.containsNumber(computer);
		long sameNumberLocation = userInput.sameNumberLocation(computer);

		strikeScore = sameNumberLocation;
		ballScore = containsNumber - sameNumberLocation;
	}

	public String getHint() {
		StringBuilder hint = new StringBuilder();

		if (ballScore != NONE) {
			hint.append(ballScore).append(BALL_HINT).append(" ");
		}

		if (strikeScore != NONE) {
			hint.append(strikeScore).append(STRIKE_HINT).append(" ");
		}

		if (ballScore == NONE && strikeScore == NONE) {
			hint.append(ZERO_HINT);
		}

		return hint.toString();
	}
}
