package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidation {
	private static final Pattern REGEX_VALIDATE_NUMBER = Pattern.compile("^[1-9]{3}");

	public static List<Integer> validatePrediction(String prediction) {
		if (!REGEX_VALIDATE_NUMBER.matcher(prediction).matches()) {
			throw new IllegalArgumentException("Invalid Prediction.");
		}
		return validateNotDuplicatedPrediction(prediction);
	}

	private static List<Integer> validateNotDuplicatedPrediction(String prediction) {
		Set<Character> set = new HashSet<>();
		for (char ch : prediction.toCharArray()) {
			set.add(ch);
		}
		if (set.size() != prediction.length()) {
			throw new IllegalArgumentException("Invalid Prediction.");
		}
		return transformToIntegerList(prediction);
	}

	private static List<Integer> transformToIntegerList(String prediction) {
		List<Integer> predictions = new ArrayList<>();
		for (int i = 0; i < prediction.length(); i++) {
			predictions.add(Integer.parseInt(prediction.substring(i, i + 1)));
		}
		return predictions;
	}
}
