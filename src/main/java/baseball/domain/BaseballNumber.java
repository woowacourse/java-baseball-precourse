package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumber {

	private final List<Number> baseballNumber;

	public BaseballNumber(List<Number> baseballNumber) {
		this.baseballNumber = baseballNumber;
	}

	public Long sameNumberLocation(BaseballNumber compareNumber) {
		long count = 0;

		count = IntStream.range(0, baseballNumber.size())
			.filter(i -> compareNumber.baseballNumber.get(i).getNo() == baseballNumber.get(i).getNo())
			.count();

		return count;
	}

	public long containsNumber(BaseballNumber compareNumber) {
		return IntStream.range(0, baseballNumber.size())
			.filter(i -> baseballNumber
				.stream()
				.map(Number::getNo)
				.collect(Collectors.toList())
				.contains(compareNumber
					.baseballNumber
					.get(i)
					.getNo()))
			.count();
	}

}
