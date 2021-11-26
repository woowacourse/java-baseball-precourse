package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import constants.Constants;

public class Converter {
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
