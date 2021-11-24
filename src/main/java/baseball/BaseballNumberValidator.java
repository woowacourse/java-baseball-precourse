package baseball;

import java.util.stream.Stream;

public class BaseballNumberValidator {
	public boolean validate(String number) {
		return isValidLength(number) && isValidCharacters(number) && isUniqueNumber(number);
	}

	private boolean isValidLength(String number) {
		return number.length() == 3;
	}

	private boolean isValidCharacters(String number) {
		return number.matches("[1-9]{3}");
	}

	private boolean isUniqueNumber(String number) {
		Stream<Character> stream = number.chars().mapToObj(c -> (char)c);
		return stream.distinct().count() == 3;
	}
}
