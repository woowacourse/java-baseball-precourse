package baseball;

import java.util.Objects;

public class JudgeResult {
	private final int strike;
	private final int ball;

	private JudgeResult(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public static JudgeResult of(int strike, int ball) {
		return new JudgeResult(strike, ball);
	}

	public static JudgeResult nothing() {
		return new JudgeResult(0, 0);
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean hasBall() {
		return ball > 0;
	}

	public boolean hasStrike() {
		return strike > 0;
	}

	public boolean isStrikeOut() {
		return strike == 3;
	}

	public boolean isNothing() {
		return strike == 0 && ball == 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		JudgeResult that = (JudgeResult) obj;
		return strike == that.strike && ball == that.ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}
}
