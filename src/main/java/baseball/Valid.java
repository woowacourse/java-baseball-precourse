package baseball;

import java.util.List;

public class Valid {
	public static final boolean VALID_SUCCESS = true;
	public static final boolean VALID_FAILED = false;
	public static final String GAME_START = "1";
	public static final String PROGRAM_EXIT = "2";

	public Valid() {}

	public static boolean validateNumbersList(List<Integer> numbers) {
		if (numbers.size() != 3) {
			return VALID_FAILED;
		}

		for (int i = 0; i < 3; i++) {
			if (numbers.get(i) < 1 || 9 < numbers.get(i)) {
				return VALID_FAILED;
			}
		}

		int number0 = numbers.get(0);
		int number1 = numbers.get(1);
		int number2 = numbers.get(2);
		if (number0 == number1
			|| number0 == number2
			|| number1 == number2) {
			return VALID_FAILED;
		}
		return VALID_SUCCESS;
	}

	public static boolean validateRestartMessage(String userInputMessage) {
		if (userInputMessage.equals(GAME_START)
			|| userInputMessage.equals(PROGRAM_EXIT)) {
			return VALID_SUCCESS;
		}
		throw new IllegalArgumentException();
	}

}
