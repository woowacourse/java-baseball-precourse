package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import constants.Constants;

public class Converter {
	public List<Integer> convertStringToIntegerList(String givenString) throws IllegalArgumentException{
		if(!checkContainAllNumber(givenString) || !checkSizeCorrect(givenString)) {
			throw new IllegalArgumentException();
		}

		int [] digits = Stream.of(givenString.split("")).mapToInt(Integer::parseInt).toArray();

		return Arrays.stream(digits)
			.boxed()
			.collect(Collectors.toList());
	}

	private boolean checkContainAllNumber (String givenString) {
		return givenString.chars().allMatch( Character::isDigit );
	}

	private boolean checkSizeCorrect(String givenString) {
		return givenString.length() == Constants.RANDOM_NUMBER_SIZE;
	}
}
