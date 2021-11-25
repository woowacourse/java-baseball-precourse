package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import constants.Constants;
import dto.CompareResult;

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

	public String convertResultToString(CompareResult result) {
		int strike = result.getStrike();
		int ball = result.getBall();

		if(strike == 0 && ball == 0) {
			return "낫싱";
		} else if(strike != 0 && ball == 0) {
			return strike + "스트라이크";
		} else if(strike == 0 && ball != 0) {
			return ball + "볼";
		}
		return ball + "볼 " + strike + "스트라이크";
	}

	public int convertStringToInt(String givenString) {
		int converted = 0;
		try {
			converted = Integer.parseInt(givenString);
		}catch (Exception e) {
			throw new IllegalArgumentException();
		}
		return converted;
	}
}
