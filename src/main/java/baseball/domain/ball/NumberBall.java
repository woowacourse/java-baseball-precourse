package baseball.domain.ball;

import baseball.domain.hint.HintType;

public class NumberBall {
	private static final String ERR_RANGE_MSG = "숫자는 1 이상, 9 이하여야 합니다.";
	private static final String ERR_INDEX_MSG =
		String.format("숫자의 인덱스는 %d 이상일 수 없습니다.", NumberBallSet.NUMBER_COUNT);

	public static final int MIN = 1;
	public static final int MAX = 9;

	private final int index;
	private final int number;

	public NumberBall(int index, int number) {
		validateRange(number);
		validateIndex(index);
		this.index = index;
		this.number = number;
	}

	private void validateRange(int number) {
		if (number < MIN || number > MAX) {
			throw new IllegalArgumentException(ERR_RANGE_MSG);
		}
	}

	private void validateIndex(int index) {
		if (index >= NumberBallSet.NUMBER_COUNT) {
			throw new IllegalArgumentException(ERR_INDEX_MSG);
		}
	}

	public HintType compare(NumberBall other) {
		if (this.number == other.number) {
			return compareByIndex(other.index);
		}
		return HintType.MISS;
	}

	private HintType compareByIndex(int otherIndex) {
		if (this.index == otherIndex) {
			return HintType.STRIKE;
		}
		return HintType.BALL;
	}
}
