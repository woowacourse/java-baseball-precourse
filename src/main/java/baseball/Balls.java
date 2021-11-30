package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

	private List<Ball> balls;

	public Balls(List<Ball> balls) {
		checkSize(balls);
		checkDuplicated(balls);
		this.balls = balls;
	}

	public static Balls createRandomBalls() {
		List<Ball> randomBalls = new ArrayList<>();
		while (randomBalls.size() < 3) {
			Ball randomBall = Ball.createRandomBall();
			if (!randomBalls.contains(randomBall)) {
				randomBalls.add(randomBall);
			}
		}
		return new Balls(randomBalls);
	}

	private void checkSize(List<Ball> balls) {
		if (balls.size() != 3) {
			throw new IllegalArgumentException("입력된 Ball은 3개여야 합니다");
		}
	}

	private void checkDuplicated(List<Ball> balls) {
		Set<Ball> set = new HashSet<>(balls);
		if (set.size() != 3) {
			throw new IllegalArgumentException("Ball의 숫자는 중복될 수 없습니다");
		}
	}

	public List<Hint> compareWith(Balls otherBalls) {
		List<Hint> hints = new ArrayList<>();
		for (int position = 0; position < 3; position++) {
			Hint hint = otherBalls.getHintsFrom(position, balls.get(position));
			hints.add(hint);
		}
		return hints;
	}

	private Hint getHintsFrom(int position, Ball otherBall) {
		if (balls.get(position).equals(otherBall)) {
			return Hint.STRIKE;
		}
		if (balls.contains(otherBall)) {
			return Hint.BALL;
		}
		return Hint.NOTHING;
	}
}
