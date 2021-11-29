package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.RandomNumbersGenerator;

public class ComputerNumbers {
	private List<BaseballNumber> numbers;
	private static final int MIN_POSITION = 0;
	private static final int MAX_POSITION = 3;

	public ComputerNumbers() {
		makeNumbers();
	}

	private void makeNumbers() {
		numbers = Arrays.stream(RandomNumbersGenerator.makeThreeRandomNumbers())
			.mapToObj(number -> new BaseballNumber(number))
			.collect(
				Collectors.toList());
	}

	public int findNumberOfStrikes(PlayerNumbers playerNumbers) {
		return (int)IntStream.range(MIN_POSITION, MAX_POSITION)
			.filter(index -> numbers.get(index).equals(playerNumbers.getNumbers().get(index)))
			.count();
	}

	public int findNumberOfBalls(PlayerNumbers playerNumbers) {
		return (int)IntStream.range(MIN_POSITION, MAX_POSITION)
			.filter(index -> playerNumbers.getNumbers().contains(numbers.get(index)))
			.filter(index -> !numbers.get(index).equals(playerNumbers.getNumbers().get(index)))
			.count();
	}
}
