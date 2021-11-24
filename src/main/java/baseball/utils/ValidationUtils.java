package baseball.utils;

import static baseball.constants.GameConstants.Digit.*;
import static baseball.constants.GameConstants.DigitRange.*;
import static baseball.constants.GameConstants.GameOverInput.*;
import static baseball.constants.GameConstants.Message.*;

import java.util.List;

public class ValidationUtils {
	public static boolean validateRandomDigits(List<Integer> numberList) {
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
		for (int i = 0; i < userInputString.length(); i++) {
			int userInputNumber = Character.getNumericValue(userInputString.charAt(i));
			if (START_INCLUSIVE.getNumber() > userInputNumber || END_INCLUSIVE.getNumber() < userInputNumber)
				throw new IllegalArgumentException(ERR_NOT_IN_RANGE.getMessage());
		}
	}

	public static void validateUserInputDigitListDuplicate(List<Integer> numberList) {
		boolean[] duplicateCheck = new boolean[END_INCLUSIVE.getNumber() + 1];

		for (Integer number : numberList) {
			if (duplicateCheck[number])
				throw new IllegalArgumentException(ERR_DUPLICATE_EXISTS.getMessage());
			duplicateCheck[number] = true;
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
