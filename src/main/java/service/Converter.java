package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import constants.Constants;
import dto.CompareResult;

public class Converter {

	public void checkGivenNumbersAvailable(String givenString) {
		if(!checkContainAllNumber(givenString) || !checkSizeCorrect(givenString, Constants.RANDOM_NUMBER_SIZE)) {
			throw new IllegalArgumentException();
		}
	}

	public void checkRestartNumberAvailable(String givenString) {
		if(!checkContainAllNumber(givenString)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkContainAllNumber (String givenString) {
		return givenString.chars().allMatch( Character::isDigit );
	}

	private boolean checkSizeCorrect(String givenString, int correctSize) {
		return givenString.length() == correctSize;
	}

	public List<Integer> convertStringToIntegerList(String givenString) throws IllegalArgumentException{
		int [] digits = Stream.of(givenString.split("")).mapToInt(Integer::parseInt).toArray();

		return Arrays.stream(digits)
			.boxed()
			.collect(Collectors.toList());
	}

	public int convertStringToInt(String givenString) {
		return Integer.parseInt(givenString);
	}


}
