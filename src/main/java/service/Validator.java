package service;

import constants.Constants;

public class Validator {

	public void validateInputString(String givenString, int correctSize) {
		if(!checkContainAllNumber(givenString) || !checkSizeCorrect(givenString, correctSize)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkContainAllNumber (String givenString) {
		return givenString.chars().allMatch( Character::isDigit );
	}

	private boolean checkSizeCorrect(String givenString, int correctSize) {
		return givenString.length() == correctSize;
	}
}
