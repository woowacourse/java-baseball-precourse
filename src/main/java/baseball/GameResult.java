package baseball;

import java.util.List;

public class GameResult {

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
		return countStrike() == 3;
	}

	public boolean hasBall() {
		return countBall() > 0;
	}

	public boolean hasStrike() {
		return countStrike() > 0;
	}

	public boolean isNothing() {
		return !hasBall() && !hasStrike();
	}
}
