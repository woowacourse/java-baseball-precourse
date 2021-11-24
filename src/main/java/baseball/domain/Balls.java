package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import baseball.utils.FormatUtil;

public class Balls {
	public static final int ZERO = 0;
	public static final int LIMITED_LENGTH = 3;

	private final List<Ball> balls;

	private Balls(String value) {
		List<Integer> nos = FormatUtil.convert(value);
		this.balls = IntStream.range(ZERO, LIMITED_LENGTH).mapToObj(i -> Ball.of(i, nos.get(i))).collect(Collectors.toList());
	}

	public static Balls of(String value) {
		return new Balls(value);
	}

	public Result compare(Balls comBalls) {
		return Result.of(balls.stream().map(comBalls::compare).collect(Collectors.toList()));
	}

	private Scores compare(Ball comBall) {
		return Scores.of(balls.stream().map(comBall::compare).collect(Collectors.toList()));
	}
}
