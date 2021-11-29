package baseball.domain.ball;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.domain.hint.HintType;

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

	public Map<HintType, Integer> compare(NumberBallSet other) {
		Map<HintType, Integer> compareMap = new HashMap<>();
		numberBalls.stream()
			.map(numberBall -> compareEach(numberBall, other))
			.forEach(hintType -> compareMap.compute(hintType, (k, v) -> {
				if (v == null) {
					return 1;
				}
				return v + 1;
			}));
		return compareMap;
	}

	private HintType compareEach(NumberBall numberBall, NumberBallSet other) {
		return other.numberBalls.stream()
			.map(numberBall::compare)
			.min(Comparator.comparing(Enum::ordinal))
			.orElse(HintType.MISS);
	}
}
