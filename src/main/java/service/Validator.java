package service;

import constants.NumberConstants;

public class Validator {

	public void validateInputString(String inputString, int correctSize) {
		if(!checkContainAllNumber(inputString) || !checkCorrectSize(inputString, correctSize)) {
			throw new IllegalArgumentException();
		}
	}

	public void validateRestartString(String restartString) {
		if(!checkContainAllNumber(restartString) || !checkCorrectRestartNumber(restartString)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkContainAllNumber (String inputString) {
		return inputString.chars().allMatch( Character::isDigit );
	}

	private boolean checkCorrectSize(String inputString, int correctSize) {
		return inputString.length() == correctSize;
	}

	private boolean checkCorrectRestartNumber(String restartString) {
		return restartString.equals(String.valueOf(NumberConstants.RESUME)) || restartString.equals(
			String.valueOf(NumberConstants.STOP));
	}
}
