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
}
