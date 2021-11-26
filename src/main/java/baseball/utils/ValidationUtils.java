package baseball.utils;

import static baseball.constants.GameConstants.Digit.*;
import static baseball.constants.GameConstants.DigitRange.*;
import static baseball.constants.GameConstants.GameOverInput.*;
import static baseball.constants.GameConstants.Message.*;

import java.util.List;
import java.util.stream.IntStream;

public class ValidationUtils {
	public static boolean validateRandomDigitsDuplicate(List<Integer> numberList) {
		boolean[] duplicateCheck = new boolean[END_INCLUSIVE.getNumber() + 1];
		for (Integer number : numberList) {
			if (duplicateCheck[number])
				return false;
			duplicateCheck[number] = true;
		}
		return true;
	}

	public static boolean validateRandomDigitsLength(List<Integer> numberList) {
		return numberList.size() == LENGTH.getNumber();
	}

	public static void validateUserInputDigitsLength(String userInputString) {
		if (userInputString.length() != LENGTH.getNumber())
			throw new IllegalArgumentException(ERR_IMPROPER_LENGTH.getMessage());
	}

	public static void validateUserInputDigitsInRange(String userInputString) {
		IntStream.range(0, userInputString.length())
			.map(i -> Character.getNumericValue(userInputString.charAt(i)))
			.filter(userInputNumber -> START_INCLUSIVE.getNumber() > userInputNumber
				|| END_INCLUSIVE.getNumber() < userInputNumber)
			.forEach(userInputNumber -> {
				throw new IllegalArgumentException(ERR_NOT_IN_RANGE.getMessage());
			});
	}

	public static void validateUserInputDigitListDuplicate(List<Integer> numberList) {
		boolean[] duplicateCheck = new boolean[END_INCLUSIVE.getNumber() + 1];

		numberList.forEach(number -> {
			if (duplicateCheck[number])
				throw new IllegalArgumentException(ERR_DUPLICATE_EXISTS.getMessage());
			duplicateCheck[number] = true;
		});
	}

	public static void validateUserGameOverInputNumber(String userInputString) {
		try {
			Integer.parseInt(userInputString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERR_IMPROPER_USER_SELECTION.getMessage());
		}
	}

	public static void validateUserGameOverInputLength(String userInputString) {
		if (userInputString.length() != INPUT_LENGTH.getNumber())
			throw new IllegalArgumentException(ERR_IMPROPER_USER_SELECTION.getMessage());
	}

	public static void validateUserGameOverInputInRange(String userInputString) {
		int userInputNumber = Integer.parseInt(userInputString);
		if (RESTART.getNumber() > userInputNumber || STOP.getNumber() < userInputNumber)
			throw new IllegalArgumentException(ERR_IMPROPER_USER_SELECTION.getMessage());
	}
}
