package baseball;

import java.util.List;

public class Valid {
	private static final boolean VALID_SUCCESS = true;
	private static final boolean VALID_FAILED = false;

	public Valid() {}

	public static boolean validateNumbersList(List<Integer> numbers) {
		if (numbers.size() != 3) {
			return VALID_FAILED;
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
}
