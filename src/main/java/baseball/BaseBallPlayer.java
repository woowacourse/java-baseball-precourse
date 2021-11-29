package baseball;

import static constants.BaseBallConstant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallPlayer {
	private List<Integer> userNumber;
	private final BaseBallInputValidator validator;

	public BaseBallPlayer() {
		this.userNumber = new ArrayList<>(NUMBER_LENGTH);
		this.validator = new BaseBallInputValidator();
	}

	public void setUserNumber() {
		System.out.println(INPUT_MESSAGE);
		String userInput = Console.readLine();
		if (!validator.checkUserInput(userInput)) {
			throw new IllegalArgumentException(INVALID_BASEBALL_INPUT_ERROR);
		}
		userInputToUserNumber(userInput);
	}

	public boolean checkUserNumber(Integer idx, Integer number) {
		return userNumber.get(idx).equals(number);
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

	private void userInputToUserNumber(String userInput) {
		List<Integer> tmpUserNumber = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			tmpUserNumber.add(Character.getNumericValue(userInput.charAt(i)));
		}
		userNumber = tmpUserNumber;
	}
}
