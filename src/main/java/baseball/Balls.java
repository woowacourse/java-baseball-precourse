package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Balls {
	private static final int MAX_LENGTH = 3;

	private List<Ball> balls = new ArrayList<>();

	public Balls() {
		balls = getRandomBalls();
	}

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

	private List<Ball> getRandomBalls() {
		AtomicInteger index = new AtomicInteger(1);
		return getUniqueNumberList().stream()
			.map(ballNumber -> new Ball(ballNumber, index.getAndIncrement()))
			.collect(Collectors.toList());
	}

	private List<Integer> getUniqueNumberList() {
		List<Integer> uniqueNumbers = new ArrayList<>();
		while (uniqueNumbers.size() < MAX_LENGTH) {
			addUniqueNumberToList(uniqueNumbers);
		}
		return uniqueNumbers;
	}

	private void addUniqueNumberToList(List<Integer> uniqueNumbers) {
		int randomNumber = Randoms.pickNumberInRange(1, 9);
		if (!uniqueNumbers.contains(randomNumber)) {
			uniqueNumbers.add(randomNumber);
		}
	}

	private boolean checkOverlap(String input) {
		String[] ballNumbers = input.split("");
		return ballNumbers.length != Arrays.stream(ballNumbers).distinct().count();
	}

	private boolean checkLength(String input) {
		return input.length() != MAX_LENGTH;
	}

}
