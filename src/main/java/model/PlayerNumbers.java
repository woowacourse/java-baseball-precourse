package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumbers {
	private List<BaseballNumber> numbers;
	private static final int MAX_SIZE = 3;

	public PlayerNumbers(String[] numbers) {
		inputPlayerNumbers(numbers);
	}

	private void inputPlayerNumbers(String[] numbers) {
		this.numbers = Arrays.stream(numbers)
			.map(number -> new BaseballNumber(number))
			.collect(Collectors.toList());
	}
}
