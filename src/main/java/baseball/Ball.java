package baseball;

import java.util.Objects;

public class Ball {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private int number;
	private int position;

	public Ball(int number, int position) {
		if (checkRange(number)) {
			throw new IllegalArgumentException("1부터 9까지의 정수만 입력해주세요.");
		}
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

	private boolean checkRange(int number) {
		return number < MIN_NUMBER || number > MAX_NUMBER;
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
