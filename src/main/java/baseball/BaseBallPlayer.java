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

	private void userInputToUserNumber(String userInput) {
		List<Integer> tmpUserNumber = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			tmpUserNumber.add(Character.getNumericValue(userInput.charAt(i)));
		}
		userNumber = tmpUserNumber;
	}

	public boolean checkUserNumberStrike(Integer idx, Integer answerNumber) {
		return userNumber.get(idx).equals(answerNumber);
	}

	public boolean checkUserNumberBall(Integer answerNumber) {
		return userNumber.contains(answerNumber);
	}
}
