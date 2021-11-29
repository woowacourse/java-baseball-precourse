package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
}
