package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
	private static final int MAX_LENGTH = 3;

	private List<Ball> balls = new ArrayList<>();

	public Balls(String input) {
		if (checkOverlap(input) || checkLength(input)) {
			throw new IllegalArgumentException();
		}

		for (char number : input.toCharArray()) {
			balls.add(new Ball(Character.getNumericValue(number), balls.size() + 1));
		}
	}

	public List<Ball> getBalls() {
		return balls;
	}

	private boolean checkOverlap(String input) {
		String[] ballNumbers = input.split("");
		return ballNumbers.length != Arrays.stream(ballNumbers).distinct().count();
	}

	private boolean checkLength(String input) {
		return input.length() != MAX_LENGTH;
	}

}
