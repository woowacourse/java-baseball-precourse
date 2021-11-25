package baseball;

import java.util.Objects;

public class GameResult {
	private int strike;
	private int ball;

	public GameResult(Balls computer, Balls user) {
		computer.getBalls().stream()
			.forEach(computerBall -> compare(computerBall, user));
	}

	protected GameResult(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	private void compare(Ball computerBall, Balls user) {
		user.getBalls().stream()
			.map(userBall -> userBall.compare(computerBall))
			.forEach(compareResult -> addCounts(compareResult));
	}

	private void addCounts(CompareResult compareResult) {
		if (compareResult.isStrike()) {
			strike++;
		}
		if (compareResult.isBall()) {
			ball++;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameResult that = (GameResult)o;
		return strike == that.strike && ball == that.ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}
}
