package baseball.domain;

import static java.lang.String.*;

import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class Ball {

	private static final int NUMBER_MIN = 1;
	private static final int NUMBER_MAX = 9;
	private static final String RANGE_ERROR = format("Ball 은 %d 이상 %d 이하여야 합니다.", NUMBER_MIN, NUMBER_MAX);

	private int number;

	public Ball(int number) {
		checkRange(number);
		this.number = number;
	}

	public static Ball createRandomBall() {
		return new Ball(Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX));
	}

	private void checkRange(int number) {
		if (number < NUMBER_MIN || number > NUMBER_MAX) {
			throw new IllegalArgumentException(RANGE_ERROR);
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
