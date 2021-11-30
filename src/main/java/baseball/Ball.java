package baseball;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Ball {

	private static final List<Ball> RANDOM_BALLS = initRandomBalls();

	private int number;

	public Ball(int number) {
		checkRange(number);
		this.number = number;
	}

	public static List<Ball> getRandomBallsSizeOf(int size) {
		Collections.shuffle(RANDOM_BALLS);
		return new ArrayList<>(RANDOM_BALLS.subList(0, size));
	}

	private static List<Ball> initRandomBalls() {
		return IntStream.rangeClosed(1, 9)
			.mapToObj(Ball::new)
			.collect(toList());
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
