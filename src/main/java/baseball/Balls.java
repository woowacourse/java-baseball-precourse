package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
	List<Integer> balls = new ArrayList<>();

	public Balls(String input) {
		if (checkException(input)) {
			throw new IllegalArgumentException();
		}

		for (char number : input.toCharArray()) {
			balls.add(Character.getNumericValue(number));
		}
	}

	private boolean checkException(String input) {
		return checkLength(input) || checkString(input) || checkOverlap(input) || checkZero(input);
	}

	private boolean checkZero(String input) {
		return input.indexOf("0") > 0;
	}

	private boolean checkOverlap(String input) {
		return input.charAt(0) == input.charAt(1)
			|| input.charAt(0) == input.charAt(2)
			|| input.charAt(1) == input.charAt(2);
	}

	private boolean checkString(String input) {
		return Arrays.stream(input.split("")).anyMatch(ball -> ball.charAt(0) < '0' || ball.charAt(0) > '9');
	}

	private boolean checkLength(String input) {
		return input.length() != 3;
	}

	public boolean isSame(List<Integer> otherBalls) {
		return balls.containsAll(otherBalls);
	}
}
