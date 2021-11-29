package baseball.player;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {

	public static String validateUserAnswer(String userAnswer) {
		String regExp = "^[1-9]{3}$";
		String removeDistinct = Arrays.stream(userAnswer.split("")).distinct().collect(Collectors.joining());

		if (!Pattern.matches(regExp, userAnswer)) {
			throw new IllegalArgumentException("잘못된 사용자 입력입니다!");
		}

		if (removeDistinct.length() != userAnswer.length()) {
			throw new IllegalArgumentException("잘못된 사용자 입력입니다!");
		}

		return userAnswer;
	}
}
