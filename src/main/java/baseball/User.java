package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
	private final BallRepository balls;

	public User(String input) {
		balls = new BallRepository(createNumbers(input));
	}

	private boolean validationNumber(int number) {
		if (number >= 1 && number <= 9) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private List<Integer> createNumbers(String input) {
		return Arrays.stream(input.split(""))
			.map(Integer::parseInt)
			.filter(this::validationNumber)
			.collect(Collectors.toList());
	}

	public BallRepository getBalls() {
		return balls;
	}
}
