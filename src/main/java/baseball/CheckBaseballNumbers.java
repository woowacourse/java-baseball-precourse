package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class CheckBaseballNumbers {
	private static final int VALID_BASEBALL_NUMBER_SIZE = 3;
	private static final int START_INDEX = 0;
	private static final int EXIST_NUMBER = 1;
	private final List<Integer> userBaseballNumbers;
	private final List<Integer> computerBaseballNumbers;

	public CheckBaseballNumbers(List<Integer> userBaseballNumbers, List<Integer> computerBaseballNumbers) {
		this.userBaseballNumbers = userBaseballNumbers;
		this.computerBaseballNumbers = computerBaseballNumbers;
	}

	public int countStrike() {
		return (int)IntStream.range(START_INDEX, VALID_BASEBALL_NUMBER_SIZE)
			.filter(i -> userBaseballNumbers.get(i).equals(computerBaseballNumbers.get(i)))
			.count();
	}

	public int countBall() {
		return (int)IntStream.range(START_INDEX, VALID_BASEBALL_NUMBER_SIZE)
			.filter(i -> {
				return !userBaseballNumbers.get(i).equals(computerBaseballNumbers.get(i)) &&
					EXIST_NUMBER == computerBaseballNumbers.stream()
						.filter(baseball -> baseball.equals(this.userBaseballNumbers.get(i)))
						.count();
			})
			.count();
	}

}
