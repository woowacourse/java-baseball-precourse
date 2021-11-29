package baseball.domain.ball;

import java.util.ArrayList;
import java.util.List;

public class NumberBallSet {

	public static final int NUMBER_COUNT = 3;

	private final List<NumberBall> numberBalls;

	public NumberBallSet(List<NumberBall> numberBalls) {
		this.numberBalls = numberBalls;
	}

	public static NumberBallSet generateRandom() {
		return from(NumberBallSetFactory.generateNumbersFromRandom());
	}

	public static NumberBallSet generateFromInput(String input) {
		return from(NumberBallSetFactory.generateNumbersFromInput(input));
	}

	private static NumberBallSet from(List<Integer> ints) {
		List<NumberBall> numberBalls = new ArrayList<>();
		for (int i = 0; i < ints.size(); i++) {
			numberBalls.add(new NumberBall(i, ints.get(i)));
		}
		return new NumberBallSet(numberBalls);
	}
}
