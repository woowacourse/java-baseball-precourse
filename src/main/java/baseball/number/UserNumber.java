package baseball.number;

import java.util.ArrayList;
import java.util.List;

import baseball.model.BaseballFactory;
import baseball.output.PrintMessage;

public class UserNumber implements BaseballFactory {
	private String inputBaseballNumbers;

	public UserNumber(String inputBaseballNumbers) {
		isValidBaseballSize(inputBaseballNumbers);
		this.inputBaseballNumbers = inputBaseballNumbers;
	}

	@Override
	public List<Integer> createBaseballNumbers() {
		List<Integer> userBaseballNumbers = new ArrayList<>();

		for (int i = 0; i < VALID_BASEBALL_NUMBER_SIZE; i++) {
			int number = inputBaseballNumbers.charAt(i) - ZERO_CHAR;
			isValidBaseballNumber(number);
			userBaseballNumbers.add(number);
		}

		isValidDuplicate(userBaseballNumbers);
		return userBaseballNumbers;
	}

	private static void isValidBaseballSize(String inputBaseballNumbers) {
		int length = inputBaseballNumbers.length();

		if (length != VALID_BASEBALL_NUMBER_SIZE) {
			throw new IllegalArgumentException(PrintMessage.USER_BASEBALL_NUMBER_SIZE_EXCEPTION_MESSAGE.getMessage());
		}

	}

	private static void isValidDuplicate(List<Integer> userBaseballNumbers) {
		if (userBaseballNumbers.stream().distinct().count() != VALID_BASEBALL_NUMBER_SIZE) {
			throw new IllegalArgumentException(PrintMessage.USER_BASEBALL_NUMBER_DUPLICATE_EXCEPTION_MESSAGE.getMessage());
		}

	}

	private static void isValidBaseballNumber(int baseballNumber) {
		if (baseballNumber < MIN_NUMBER || baseballNumber > MAX_NUMBER) {
			throw new IllegalArgumentException(PrintMessage.USER_BASEBALL_NUMBER_FORMAT_EXCEPTION_MESSAGE.getMessage());
		}

	}

}
