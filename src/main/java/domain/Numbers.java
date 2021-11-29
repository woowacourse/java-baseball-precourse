package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
	protected static final int NUMBERS_SIZE = 3;
	protected static final int MIN_NUMBER = 1;
	protected static final int MAX_NUMBER = 9;

	protected List<Number> numbers;

	public Numbers() {
	}

	public Numbers(String input) {
		validateDigit(input);
		validateLength(input);
		validateDuplication(input);

		this.numbers = generateNumbersFromInput(input);
	}

	private void validateDigit(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
		}
	}

	private void validateLength(String input) {
		if (input.length() != NUMBERS_SIZE) {
			throw new IllegalArgumentException("3글자를 입력해야합니다.");
		}
	}

	private void validateDuplication(String input) {
		boolean isDuplicated = Arrays.stream(input.split(""))
			.distinct()
			.count() < NUMBERS_SIZE;

		if (isDuplicated) {
			throw new IllegalArgumentException("서로 다른 숫자를 입력해야합니다.");
		}
	}

	private List<Number> generateNumbersFromInput(String input) {
		return Arrays.stream(input.split(""))
			.map(letter -> new Number(Integer.parseInt(letter)))
			.collect(Collectors.toList());
	}

	public boolean hasNumber(Number number) {
		return this.numbers.contains(number);
	}

	public boolean isSamePosition(Number number, int position) {
		int numberIndex = this.numbers.indexOf(number);
		return numberIndex == position;
	}

}
