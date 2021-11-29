package baseball.domain.ball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import baseball._domain.HintType;

public class NumberBallSet {

	public static final int NUMBER_COUNT = 3;

	private final List<NumberBall> numberBalls;

	public NumberBallSet(List<NumberBall> numberBalls) {
		this.numberBalls = numberBalls;
	}

	public static NumberBallSet generateRandom() {
		return from(NumberBallSetFactory.generateNumbersFromRandom());
	}

	private static NumberBallSet from(List<Integer> ints) {
		List<NumberBall> numberBalls = new ArrayList<>();
		for (int i = 0; i < ints.size(); i++) {
			numberBalls.add(new NumberBall(i, ints.get(i)));
		}
		return new NumberBallSet(numberBalls);
	}
}
