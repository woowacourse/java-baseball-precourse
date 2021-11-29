package baseball.player;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import baseball.constant.Constant;

public class Validator {

	public static String validateUserAnswer(String userAnswer) {
		String regExp = "^[1-9]{3}$";
		String removeDistinct = Arrays.stream(userAnswer.split("")).distinct().collect(Collectors.joining());

		if (!Pattern.matches(regExp, userAnswer)) {
			throw new IllegalArgumentException(Constant.WRONG_INPUT_MESSAGE);
		}

		if (removeDistinct.length() != userAnswer.length()) {
			throw new IllegalArgumentException(Constant.WRONG_INPUT_MESSAGE);
		}

		return userAnswer;
	}
}
