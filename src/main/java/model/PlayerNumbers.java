package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumbers {
	private static final int MAX_SIZE = 3;
	private List<BaseballNumber> numbers;

	public PlayerNumbers(String[] numbers) {
		isValideNumbers(numbers);
		inputPlayerNumbers(numbers);
	}

	private void inputPlayerNumbers(String[] numbers) {
		this.numbers = Arrays.stream(numbers)
			.map(number -> new BaseballNumber(number))
			.collect(Collectors.toList());
	}

	private void isValideNumbers(String[] numbers) {
		int numberCount = numbers.length;

		if (numbers.length != MAX_SIZE) {
			throw new IllegalArgumentException("입력한 숫자가 3자리가 아닙니다.");
		}

		if (Arrays.stream(numbers).distinct().count() != numberCount) {
			throw new IllegalArgumentException("입력한 숫자중 중복되는 숫자가 있습니다.");
		}
	}

	public List<BaseballNumber> getNumbers() {
		return numbers;
	}
}
