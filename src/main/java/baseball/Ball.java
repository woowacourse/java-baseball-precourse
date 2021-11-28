package baseball;

public class Ball {

	private int number;

	public Ball(int number) {
		checkNotZero(number);
		this.number = number;
	}

	private void checkNotZero(int number) {
		if (number == 0) {
			throw new IllegalArgumentException("Ball 은 0일 수 없습니다");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !o.getClass().equals(Ball.class)) {
			return false;
		}
		Ball other = (Ball)o;
		return this.number == other.number;
	}
}
