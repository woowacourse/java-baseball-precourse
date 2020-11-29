package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
	public static boolean isUseable(String number) {
		Set<String> set;
		List<String> randomList = Arrays.asList(number.split(""));

		set = new HashSet<String>(randomList);

		if (number.contains("0")) {
			return false;
		}

		return set.size() == GameManager.MAX_NUM_LENGTH;
	}

	public static boolean isStrinNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
