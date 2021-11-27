package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Balls {
	private static final int MAX_LENGTH = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int INIT_POSITION = 1;

	private List<Ball> balls = new ArrayList<>();

	public Balls() {
		balls = getRandomBalls();
	}

	public Balls(String input) {
		if (checkOverlap(input) || checkLength(input)) {
			throw new IllegalArgumentException();
		}

		AtomicInteger index = new AtomicInteger(INIT_POSITION);
		for (char number : input.toCharArray()) {
			balls.add(new Ball(Character.getNumericValue(number), index.getAndIncrement()));
		}
	}

	public List<Ball> getBalls() {
		return balls;
	}

	private List<Ball> getRandomBalls() {
		AtomicInteger index = new AtomicInteger(INIT_POSITION);
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
		int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
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
