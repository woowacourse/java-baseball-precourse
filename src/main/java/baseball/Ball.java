package baseball;

public class Ball {

	private int number;

	public Ball(int number) {
		checkRange(number);
		this.number = number;
	}

	private void checkRange(int number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException("Ball 은 1 이상 9 이하여야 합니다.");
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
