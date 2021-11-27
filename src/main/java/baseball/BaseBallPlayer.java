package baseball;

import static constants.BaseBallConstant.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallPlayer {
	private List<Integer> userNumber;

	public BaseBallPlayer() {
		this.userNumber = new ArrayList<>(NUMBER_LENGTH);
	}

	public void getUserNumber() {
		System.out.println(INPUT_MESSAGE);
		String userInput = Console.readLine();
		if (!checkUserInput(userInput)) {
			throw new IllegalArgumentException(INVALID_BASEBALL_INPUT_ERROR);
		}
		userInputToUserNumber(userInput);
	}

	public int checkNumber(Integer providerNumber, Integer index) {
		if (userNumber.get(index).equals(providerNumber)) {
			return STRIKE_RESULT;
		}
		if (userNumber.contains(providerNumber)) {
			return BALL_RESULT;
		}
		return NOTHING_RESULT;
	}

	private boolean checkUserInput(String userInput) {
		return isAllDigit(userInput) && isRightLength(userInput) && isRightNumberRange(userInput) && isNotDuplicate(
			userInput);
	}

	private boolean isRightLength(String userInput) {
		return userInput.length() == 3;
	}

	private boolean isRightNumberRange(String userInput) {
		for (int i = 0; i < 3; i++) {
			if (userInput.charAt(i) - '0' < 1 || 9 < userInput.charAt(i) - '0') {
				return false;
			}
		}
		return true;
	}

	private boolean isAllDigit(String userInput) {
		for (int i = 0; i < 3; i++) {
			char oneDigit = userInput.charAt(i);
			if (!Character.isDigit(oneDigit)) {
				return false;
			}
		}
		return true;
	}

	private boolean isNotDuplicate(String userInput) {
		Set<Character> inputDigits = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			inputDigits.add(userInput.charAt(i));
		}
		return inputDigits.size() == 3;
	}

	private void userInputToUserNumber(String userInput) {
		List<Integer> tmpUserNumber = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			tmpUserNumber.add(Character.getNumericValue(userInput.charAt(i)));
		}
		userNumber = tmpUserNumber;
	}
}
