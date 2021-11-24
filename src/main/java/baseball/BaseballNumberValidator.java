package baseball;

import java.util.HashSet;
import java.util.Set;

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
		Set<Character> set = new HashSet<>();
		for (Character ch : number.toCharArray()) {
			set.add(ch);
		}
		return set.size() == 3;
	}
}
