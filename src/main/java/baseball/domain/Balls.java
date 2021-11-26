package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import baseball.utils.FormatUtil;

public class Balls {
	public static final int ZERO = 0;
	public static final int LIMITED_LENGTH = 3;
	public static final String EMPTY_STRING = "";

	private final List<Ball> balls;

	private Balls(String value) {
		List<Integer> nos = FormatUtil.convert(value);
		this.balls = IntStream.range(ZERO, LIMITED_LENGTH).mapToObj(i -> Ball.of(i, nos.get(i))).collect(Collectors.toList());
	}

	public static Balls from(String value) {
		checkValidation(value);
		return new Balls(value);
	}

	private static void checkValidation(String value) {
		checkLength(value);
		checkDuplicate(value);
	}

	private static void checkDuplicate(String value) {
		if (hasDuplicate(value)) {
			throw new IllegalArgumentException("중복된 숫자가 없도록 입력해주세요.");
		}
	}

	private static void checkLength(String value) {
		if (!isLimitedLength(value)) {
			throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
		}
	}

	private static boolean isLimitedLength(String value) {
		return value.length() == LIMITED_LENGTH;
	}

	private static boolean hasDuplicate(String value) {
		return distinctCount(value) != LIMITED_LENGTH;
	}

	private static int distinctCount(String value) {
		return (int)Arrays.stream(value.split(EMPTY_STRING)).distinct().count();
	}

	public Result compare(Balls comBalls) {
		return Result.from(balls.stream().map(comBalls::compare).collect(Collectors.toList()));
	}

	private Scores compare(Ball comBall) {
		return Scores.from(balls.stream().map(comBall::compare).collect(Collectors.toList()));
	}
}
