package baseball.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumber {

	private static final int SIZE = 3;
	private static final String SIZE_ERROR = "1에서 9까지의 임의의 수 3개의 숫자를 입력해주세요.";
	private static final String DUPLICATE_ERROR = "서로 다른 임의의 수 3개를 입력해주세요.";

	private final List<Number> baseballNumber;

	public BaseballNumber(List<Number> baseballNumber) {
		validateSize(baseballNumber);
		validateDuplicate(baseballNumber);
		this.baseballNumber = baseballNumber;
	}

	public void validateSize(List<Number> baseballNumber) {
		if (baseballNumber.size() != SIZE) {
			throw new IllegalArgumentException(SIZE_ERROR);
		}
	}

	public void validateDuplicate(List<Number> baseballNumber) {
		Set<Integer> duplicateInput;

		try {
			duplicateInput = baseballNumber
				.stream()
				.map(Number::getNo)
				.collect(Collectors.toSet());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(DUPLICATE_ERROR);
		}

		if (duplicateInput.size() != SIZE) {
			throw new IllegalArgumentException(DUPLICATE_ERROR);
		}
	}

	public Long sameNumberLocation(BaseballNumber compareNumber) {
		return IntStream.range(0, baseballNumber.size())
			.filter(i -> compareNumber.baseballNumber.get(i).getNo() == baseballNumber.get(i).getNo())
			.count();
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
