package service;

import java.util.List;

import constants.Constants;

public class Validator {

	public void validateGivenString(String givenString, int correctSize) {
		if(!checkContainAllNumber(givenString) || !checkCorrectSize(givenString, correctSize)) {
			throw new IllegalArgumentException();
		}
	}

	public void validateRestartString(String restartString) {
		if(!checkContainAllNumber(restartString) || !checkCorrectRestartNumber(restartString)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkContainAllNumber (String givenString) {
		return givenString.chars().allMatch( Character::isDigit );
	}

	private boolean checkCorrectSize(String givenString, int correctSize) {
		return givenString.length() == correctSize;
	}

	private boolean checkCorrectRestartNumber(String restartString) {
		return restartString.equals(String.valueOf(Constants.RESUME)) || restartString.equals(
			String.valueOf(Constants.STOP));
	}
}
