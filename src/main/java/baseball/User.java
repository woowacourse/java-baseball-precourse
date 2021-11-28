package baseball;

import static baseball.Constant.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class User {
	private final BallRepository ballRepository = new BallRepository();

	public void insertNumbers(String input) {
		ballRepository.clearNumbers();
		ballRepository.insertNumbers(createNumbers(input));
	}

	private boolean validationNumber(int number) {
		if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private List<Integer> createNumbers(String input) {
		validateDuplicate(input);
		return Arrays.stream(input.split(""))
			.map(Integer::parseInt)
			.filter(this::validationNumber)
			.collect(Collectors.toList());
	}

	private void validateDuplicate(String input) {
		HashSet<Character> tempSet = new HashSet<>();
		for (int i = 0; i < MAX_BALL_SIZE; i++) {
			tempSet.add(input.charAt(i));
		}
		if (tempSet.size() != MAX_BALL_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	public List<Ball> getBalls() {
		return ballRepository.getBalls();
	}
}
