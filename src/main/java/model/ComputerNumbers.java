package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.RandomNumbersGenerator;

public class ComputerNumbers {
	private List<BaseballNumber> numbers;

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
		return (int)IntStream.range(0, 3)
			.filter(index -> numbers.get(index).equals(playerNumbers.getNumbers().get(index)))
			.count();
	}

	public int findNumberOfBalls(PlayerNumbers playerNumbers) {
		return (int)IntStream.range(0, 3)
			.filter(index -> playerNumbers.getNumbers().contains(numbers.get(index)))
			.filter(index -> !numbers.get(index).equals(playerNumbers.getNumbers().get(index)))
			.count();
	}
}
