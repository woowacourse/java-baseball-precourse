package baseball.domain;

public class Game {

	private static final String EXCEPTION = "1또는 2를 입력해주세요.";
	private static final int GAME_RUN = 1;
	private static final int GAME_STOP = 2;

	private final int gameProgress;

	public Game(String gameProgress) {
		this.gameProgress = validate(gameProgress);
	}

	public int validate(String gameProgress) {
		int gameProgressParsed;

		try {
			gameProgressParsed = Integer.parseInt(gameProgress);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(EXCEPTION);
		}
		if (gameProgressParsed != GAME_RUN && gameProgressParsed != GAME_STOP) {
			throw new IllegalArgumentException(EXCEPTION);
		}

		return gameProgressParsed;
	}

	public boolean continueGame() {
		return gameProgress == GAME_RUN;
	}
}
