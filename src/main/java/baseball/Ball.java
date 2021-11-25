package baseball;

import java.util.Objects;

public class Ball {
	private int number;
	private int position;

	public Ball(int number, int position) {
		this.number = number;
		this.position = position;
	}

	public CompareResult compare(Ball ball) {
		if (this.equals(ball)) {
			return CompareResult.STRIKE;
		}
		if (ball.isSameNumber(number)) {
			return CompareResult.BALL;
		}
		return CompareResult.NOTHING;
	}

	private boolean isSameNumber(int number) {
		return this.number == number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return number == ball.number && position == ball.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, position);
	}
}
