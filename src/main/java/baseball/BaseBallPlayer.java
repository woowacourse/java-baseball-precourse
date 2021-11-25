package baseball;

import static constants.SystemMessage.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallPlayer {
	private static List<Integer> userNumber = new ArrayList<>(3);

	public static void getUserNumber() {
		System.out.println(INPUT_MESSAGE);
		String userInput = Console.readLine();
		if (!checkUserInput(userInput)) {
			throw new IllegalArgumentException();
		}
		userInputToUserNumber(userInput);
		System.out.println(userNumber);
	}

	private static boolean checkUserInput(String userInput) {
		return isAllDigit(userInput) && isRightLength(userInput) && isRightNumberRange(userInput) && isNotDuplicate(
			userInput);

	}

	private static boolean isRightLength(String userInput) {
		return userInput.length() <= 4;
	}

	private static boolean isRightNumberRange(String userInput) {
		for (int i = 0; i < 3; i++) {
			if (userInput.charAt(i) - '0' < 1 || 9 < userInput.charAt(i) - '0') {
				return false;
			}
		}
		return true;
	}

	private static boolean isAllDigit(String userInput) {
		for (int i = 0; i < 3; i++) {
			char oneDigit = userInput.charAt(i);
			if (!Character.isDigit(oneDigit)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isNotDuplicate(String userInput) {
		Set<Character> inputDigits = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			inputDigits.add(userInput.charAt(i));
		}
		return inputDigits.size() == 3;
	}

	private static void userInputToUserNumber(String userInput) {
		for (int i = 0; i < 3; i++) {
			userNumber.add(Character.getNumericValue(userInput.charAt(i)));
		}
	}

}
