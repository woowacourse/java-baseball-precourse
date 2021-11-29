package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.RandomNumbersGenerator;

public class ComputerNumbers {
	private static final int MIN_POSITION = 0;
	private static final int MAX_POSITION = 3;
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
		return (int)IntStream.range(MIN_POSITION, MAX_POSITION)
			.filter(index -> isStrike(index, playerNumbers))
			.count();
	}

	private boolean isStrike(int index, PlayerNumbers playerNumbers) {
		if (numbers.get(index).equals(playerNumbers.getNumbers().get(index))) {
			return true;
		}
		return false;
	}

	public int findNumberOfBalls(PlayerNumbers playerNumbers) {
		return (int)IntStream.range(MIN_POSITION, MAX_POSITION)
			.filter(index -> playerNumbers.getNumbers().contains(numbers.get(index)))
			.filter(index -> !isStrike(index, playerNumbers))
			.count();
	}
}
