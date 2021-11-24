package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumberValidator {
	public boolean validate(String number) {
		Set<Character> set = new HashSet<>();
		for (Character ch : toCharArray(number)) {
			set.add(ch);
		}
		return set.size() == 3;
	}

	private char[] toCharArray(String number) {
		return number.toCharArray();
	}
}
