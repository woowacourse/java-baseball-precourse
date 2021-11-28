package baseball;

import static baseball.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class BallRepository {
	List<Ball> balls = new ArrayList<>();

	public void insertNumbers(List<Integer> input) {
		validateNumbers(input);
		for (int i = 0; i < input.size(); i++) {
			if (validateNumber(input.get(i))) {
				balls.add(new Ball(i, input.get(i)));
			}
		}
	}

	public void clearNumbers() {
		balls.clear();
	}

	private boolean validateNumber(int number) {
		if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private void validateNumbers(List<Integer> numbers) {
		if (numbers.size() != MAX_BALL_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	public List<Ball> getBalls() {
		return balls;
	}
}
