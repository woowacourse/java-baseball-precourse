package baseball.domain.hint;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import baseball.domain.ball.NumberBallSet;

public class Hint {
	private static final String NOTHING = "낫싱";

	private Map<HintType, Integer> collect;

	private Hint(Map<HintType, Integer> collect) {
		this.collect = collect;
	}

	public static Hint compareNumberBallSets(NumberBallSet users, NumberBallSet randoms) {
		Map<HintType, Integer> collect = createEmptyMap();
		Map<HintType, Integer> compare = users.compare(randoms);
		compare.forEach((k, v) -> collect.merge(k, v, Integer::sum));
		return new Hint(collect);
	}

	private static Map<HintType, Integer> createEmptyMap() {
		return Arrays.stream(HintType.values())
			.collect(Collectors.toMap(hintType -> hintType, hintType -> 0));
	}

	public boolean isAnswer() {
		return collect.get(HintType.STRIKE) == NumberBallSet.NUMBER_COUNT;
	}

	public String giveHint() {
		if (isAllMissing()) {
			return giveNothingHint();
		}
		return giveBallAndStrikeHint();
	}

	private boolean isAllMissing() {
		return collect.get(HintType.STRIKE) == 0 && collect.get(HintType.BALL) == 0;
	}

	private String giveNothingHint() {
		return NOTHING;
	}

	private String giveBallAndStrikeHint() {
		return String.join(" ",
			HintType.BALL.represent(collect.get(HintType.BALL)),
			HintType.STRIKE.represent(collect.get(HintType.STRIKE))
		).trim();
	}

}
