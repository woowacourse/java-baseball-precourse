package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private static final int NUMBER_LENGTH = 3;
	private static final int MIN = '1';
	private static final int MAX = '9';
	private static List<Integer> inputNumbers;

	public static List<Integer> getNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();
		validateInput(input);
		inputNumbers = convertStringToIntegerList(input);
		return inputNumbers;
	}

	private static List<Integer> convertStringToIntegerList(String number) {
		return Arrays.stream(number.split(""))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private static void validateInput(String input) {
		if (!validateLength(input) || !validateValue(input) || !validateDuplication(input)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean validateDuplication(String input) {
		Set<Character> uniqueNumbers = new HashSet<>();
		for (char number : input.toCharArray()) {
			uniqueNumbers.add(number);
		}
		return uniqueNumbers.size() == NUMBER_LENGTH;
	}

	private static boolean validateLength(String input) {
		for (char number : input.toCharArray()) {
			if (number < MIN || number > MAX) {
				return false;
			}
		}
		return true;
	}

	private static boolean validateValue(String input) {
		return input.length() == NUMBER_LENGTH;
	}
}
