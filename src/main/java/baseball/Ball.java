package baseball;

import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class Ball {

	private int number;

	public Ball(int number) {
		checkRange(number);
		this.number = number;
	}

	public static Ball createRandomBall() {
		return new Ball(Randoms.pickNumberInRange(1, 9));
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

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
