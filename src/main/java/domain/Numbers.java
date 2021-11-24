package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Numbers {

	private static final int NUMBERS_SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final List<Number> numbers;

	public Numbers() {
		this.numbers = generateRandomNumbers();
	}

	public Numbers(String input) {
		List<Number> generatedNumbers = generateNumbersFromInput(input);
		List<Number> distinctNumbers = removeDuplicationFromNumbers(generatedNumbers);

		if (distinctNumbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException("숫자는 3개의 서로 다른 숫자를 입력해야 합니다.");
		}

		this.numbers = distinctNumbers;
	}

	private List<Number> removeDuplicationFromNumbers(List<Number> numbers) {
		return numbers.stream()
			.distinct()
			.collect(Collectors.toList());
	}

	private List<Number> generateNumbersFromInput(String input) {
		return Arrays.stream(input.split(""))
			.map(Number::new)
			.collect(Collectors.toList());
	}

	private List<Number> generateRandomNumbers() {
		List<Number> generatedNumbers = new ArrayList<Number>();

		while (generatedNumbers.size() < NUMBERS_SIZE) {
			Number nextNumber = new Number(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			if (!generatedNumbers.contains(nextNumber)) {
				generatedNumbers.add(nextNumber);
			}
		}

		return generatedNumbers;
	}

}
