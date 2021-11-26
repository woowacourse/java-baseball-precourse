package baseball;

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
		if (number >= 1 && number <= 9) {
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
		for (int i = 0; i < 3; i++) {
			tempSet.add(input.charAt(i));
		}
		if (tempSet.size() != 3) {
			throw new IllegalArgumentException();
		}
	}

	public List<Ball> getBalls() {
		return ballRepository.getBalls();
	}
}
