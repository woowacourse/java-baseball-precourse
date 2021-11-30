package baseball.domain;

public class Game {

	private static final String EXCEPTION = "잘못된 값을 입력했습니다.";
	private static final int GAME_RUN = 1;
	private static final int GAME_STOP = 2;

	private final int gameProgress;

	public Game(String gameProgress) {
		int gameProgressParsed;

		try {
			gameProgressParsed = Integer.parseInt(gameProgress);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(EXCEPTION);
		}
		if (gameProgressParsed != GAME_RUN && gameProgressParsed != GAME_STOP) {
			throw new IllegalArgumentException(EXCEPTION);
		}

		this.gameProgress = gameProgressParsed;
	}

	public boolean continueGame() {
		return this.gameProgress == GAME_RUN;
	}
}
