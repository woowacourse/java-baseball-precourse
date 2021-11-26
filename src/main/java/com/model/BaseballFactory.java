package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.io.Output;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballFactory {
	private static final char ZERO_CHAR = '0';
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int VALID_BASEBALL_NUMBER_SIZE = 3;
	private static final int EXIST_NUMBER = 1;
	private static final int START_INDEX = 0;

	public static List<Integer> createUserBaseballNumbers(String baseballNumbers) {
		List<Integer> userBaseballNumbers = new ArrayList<>();
		isValidBaseballSize(baseballNumbers);

		for (int i = 0; i < VALID_BASEBALL_NUMBER_SIZE; i++) {
			int number = baseballNumbers.charAt(i) - ZERO_CHAR;
			isValidBaseballNumber(number);
			userBaseballNumbers.add(number);
		}

		isValidDuplicate(userBaseballNumbers);
		return userBaseballNumbers;
	}

	public static List<Integer> createComputerBaseballNumbers() {
		List<Integer> computerBaseballNumbers = new ArrayList<>();

		while (computerBaseballNumbers.size() != VALID_BASEBALL_NUMBER_SIZE) {
			int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			int length = computerBaseballNumbers.size();

			if (isValidDuplicate(number, computerBaseballNumbers, length) == true) {
				computerBaseballNumbers.add(number);
			}
		}

		return computerBaseballNumbers;
	}

	private static void isValidBaseballSize(String baseballNumbers) {
		int length = baseballNumbers.length();

		if (length != VALID_BASEBALL_NUMBER_SIZE) {
			throw new IllegalArgumentException(Output.INPUT_NUMBER_SIZE_EXCEPTION_MESSAGE);
		}

	}

	private static void isValidDuplicate(List<Integer> userBaseballNumbers) {
		if (userBaseballNumbers.stream().distinct().count() != VALID_BASEBALL_NUMBER_SIZE) {
			throw new IllegalArgumentException(Output.INPUT_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
		}
	}

	private static void isValidBaseballNumber(int baseballNumber) {
		if (baseballNumber < MIN_NUMBER || baseballNumber > MAX_NUMBER) {
			throw new IllegalArgumentException(Output.INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
		}

	}

	private static boolean isValidDuplicate(int number, List<Integer> computerBaseballNumbers, int length) {
		if (IntStream.range(START_INDEX, length)
		.filter(i -> computerBaseballNumbers.get(i).equals(number))
		.count() == EXIST_NUMBER) {
			return false;
		} else {
			return true;
		}
	}

}
