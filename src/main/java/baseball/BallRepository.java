package baseball;

import java.util.ArrayList;
import java.util.List;

public class BallRepository {
	List<Ball> balls = new ArrayList<>();

	public BallRepository(List<Integer> input) {
		validateNumbers(input);
		for (int i = 0; i < input.size(); i++) {
			if (validateNumber(input.get(i))) {
				balls.add(new Ball(i, input.get(i)));
			}
		}
	}

	private boolean validateNumber(int number) {
		if (number >= 1 && number <= 9) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private void validateNumbers(List<Integer> numbers) {
		if (numbers.size() != 3) {
			throw new IllegalArgumentException();
		}
	}

	public List<Ball> getBalls() {
		return balls;
	}
}
