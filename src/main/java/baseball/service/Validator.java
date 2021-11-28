package baseball.service;

import java.util.List;

import baseball.constants.RandomNumberConstant;
import baseball.constants.StatementConstant;

public class Validator {

	public void validateInputString(String inputString) {
		if(!checkAllNumber(inputString)
			|| !checkSize(inputString, RandomNumberConstant.RANDOM_NUMBER_SIZE)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkAllNumber(String inputString) {
		return inputString.chars().allMatch( Character::isDigit );
	}

	private boolean checkSize(String inputString, int correctSize) {
		return inputString.length() == correctSize;
	}

	public void validateInputNumbers(List<Integer> inputNumbers) {
		if(!checkRangeInputNumbers(inputNumbers) || !checkInputNumbersUnique(inputNumbers)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkRangeInputNumbers(List<Integer> inputNumbers) {
		return !inputNumbers.contains(0);
	}

	private boolean checkInputNumbersUnique(List<Integer> inputNumbers) {
		return inputNumbers.stream().distinct().count() == RandomNumberConstant.RANDOM_NUMBER_SIZE;
	}

	public void validateRestartString(String restartString) {
		if(!checkAllNumber(restartString)) {
			throw new IllegalArgumentException();
		}
	}

	public void validateRestartNumber(int restartInteger) {
		if(!checkCorrectRestartInteger(restartInteger)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkCorrectRestartInteger(int restartInteger) {
		return restartInteger == StatementConstant.RESUME || restartInteger == StatementConstant.STOP;
	}
}
