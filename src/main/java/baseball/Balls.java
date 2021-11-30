package baseball;

import static java.lang.String.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

	private static final int BALL_COUNT = 3;
	private static final String COUNT_ERROR = format("입력된 Ball은 %d개여야 합니다.", BALL_COUNT);
	private static final String DUPLICATE_ERROR = "Ball의 숫자는 중복될 수 없습니다.";

	private List<Ball> balls;

	public Balls(List<Ball> balls) {
		checkSize(balls);
		checkDuplicated(balls);
		this.balls = balls;
	}

	public static Balls createRandomBalls() {
		List<Ball> randomBalls = new ArrayList<>();
		while (randomBalls.size() < BALL_COUNT) {
			Ball randomBall = Ball.createRandomBall();
			if (!randomBalls.contains(randomBall)) {
				randomBalls.add(randomBall);
			}
		}
		return new Balls(randomBalls);
	}

	private void checkSize(List<Ball> balls) {
		if (balls.size() != BALL_COUNT) {
			throw new IllegalArgumentException(COUNT_ERROR);
		}
	}

	private void checkDuplicated(List<Ball> balls) {
		Set<Ball> set = new HashSet<>(balls);
		if (set.size() != BALL_COUNT) {
			throw new IllegalArgumentException(DUPLICATE_ERROR);
		}
	}

	public List<Hint> compareWith(Balls otherBalls) {
		List<Hint> hints = new ArrayList<>();
		for (int position = 0; position < BALL_COUNT; position++) {
			Hint hint = otherBalls.getHintsFrom(position, balls.get(position));
			hints.add(hint);
		}
		return hints;
	}

	private Hint getHintsFrom(int position, Ball otherBall) {
		if (containsExactly(position, otherBall)) {
			return Hint.STRIKE;
		}
		if (contains(otherBall)) {
			return Hint.BALL;
		}
		return Hint.NOTHING;
	}

	private boolean containsExactly(int position, Ball otherBall) {
		return balls.get(position).equals(otherBall);
	}

	private boolean contains(Ball otherBall) {
		return balls.contains(otherBall);
	}
}
