package baseball.domain;

import java.util.List;

public class GameResult {

	private static final int EXIST_COUNT_MIN = 0;
	private static final int GAME_END_STRIKE_COUNT = 3;

	private List<Hint> hints;

	public GameResult(List<Hint> hints) {
		this.hints = hints;
	}

	//view에서 출력을 위한 getter
	public long countBall() {
		return hints.stream()
			.filter(Hint::isBall)
			.count();
	}

	public long countStrike() {
		return hints.stream()
			.filter(Hint::isStrike)
			.count();
	}

	public boolean isPlayerWin() {
		return countStrike() == GAME_END_STRIKE_COUNT;
	}

	public boolean hasBall() {
		return countBall() > EXIST_COUNT_MIN;
	}

	public boolean hasStrike() {
		return countStrike() > EXIST_COUNT_MIN;
	}

	public boolean isNothing() {
		return !hasBall() && !hasStrike();
	}
}
