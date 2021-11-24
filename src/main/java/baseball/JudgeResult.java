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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JudgeResult that = (JudgeResult) o;
		return strike == that.strike && ball == that.ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}
}
