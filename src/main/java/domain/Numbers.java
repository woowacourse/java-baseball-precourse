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
		List<Number> generatedNumbers = generateNumbersFromInput(input);
		List<Number> distinctNumbers = removeDuplicatedNumbers(generatedNumbers);

		if (distinctNumbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException("숫자는 3개의 서로 다른 숫자를 입력해야 합니다.");
		}

		this.numbers = distinctNumbers;
	}

	public int find(Number number) {
		return this.numbers.indexOf(number);
	}

	private int convertLetterToInt(String letter) {
		try {
			return Integer.parseInt(letter);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
		}
	}

	private List<Number> generateNumbersFromInput(String input) {
		return Arrays.stream(input.split(""))
			.map(letter -> new Number(convertLetterToInt(letter)))
			.collect(Collectors.toList());
	}

	private List<Number> removeDuplicatedNumbers(List<Number> numbers) {
		return numbers.stream()
			.distinct()
			.collect(Collectors.toList());
	}

}
