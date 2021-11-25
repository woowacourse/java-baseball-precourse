package baseball;

import java.util.List;

public class Valid {
	public static final boolean VALID_SUCCESS = true;
	public static final boolean VALID_FAILED = false;
	public static final String GAME_START = "1";
	public static final String PROGRAM_EXIT = "2";

	public Valid() {
	}

	public static boolean validateNumbersList(List<Integer> numbers) {
		if (numbers.size() != 3) {
			return VALID_FAILED;
		}

		for (int i = 0; i < 3; i++) {
			if (numbers.get(i) < 1 || 9 < numbers.get(i)) {
				return VALID_FAILED;
			}
		}
		if (numbers.stream().distinct().count() != 3) {
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
