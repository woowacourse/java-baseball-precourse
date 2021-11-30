package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumbers {
	static final int NUMBERS_SIZE = 3;
	static final int MIN_NUMBER = 1;
	static final int MAX_NUMBER = 9;

	protected List<BaseballNumber> baseballNumbers;

	public BaseballNumbers() {
	}

	public BaseballNumbers(String input) {
		validateInteger(input);
		validateDuplication(input);
		validateLength(input);
		this.baseballNumbers = generateBaseballNumbers(input);
	}

	private void validateInteger(String input) {
		try {
			Arrays.stream(input.split(""))
				.forEach(Integer::parseInt);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력은 정수만 가능합니다.");
		}
	}

	private void validateDuplication(String input) {
		boolean isDuplicated = Arrays.stream(input.split(""))
			.distinct()
			.count() < NUMBERS_SIZE;
		if (isDuplicated) {
			throw new IllegalArgumentException("서로 다른 숫자(1~9)를 입력해야합니다.");
		}
	}

	private void validateLength(String input) {
		if (input.length() != NUMBERS_SIZE) {
			throw new IllegalArgumentException("3자리 정수를 입력해야 합니다.");
		}
	}

	private List<BaseballNumber> generateBaseballNumbers(String input) {
		return Arrays.stream(input.split(""))
			.map(letter -> new BaseballNumber(Integer.parseInt(letter)))
			.collect(Collectors.toList());
	}

	public boolean hasNumber(BaseballNumber baseballNumber) {
		return this.baseballNumbers.contains(baseballNumber);
	}

	public boolean isRightPosition(BaseballNumber baseballNumber, int position) {
		int numberIndex = this.baseballNumbers.indexOf(baseballNumber);
		return numberIndex == position;
	}
}
