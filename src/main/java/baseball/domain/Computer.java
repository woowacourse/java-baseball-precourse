package baseball.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private static final int MAX_NUMBER_SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private final BaseballNumber baseballNumber;

	public Computer() {

		this.baseballNumber = new BaseballNumber(
			new ArrayList<>(makeRandomList()
				.stream()
				.map(Number::new)
				.collect(Collectors.toList()))
		);

	}

	public ArrayList<Integer> makeRandomList() {
		ArrayList<Integer> numbers = new ArrayList<>();

		while (numbers.size() < MAX_NUMBER_SIZE) {
			numbers.add(makeRandomNumber(numbers));
		}

		return numbers;
	}

	private int makeRandomNumber(ArrayList<Integer> numbers) {
		int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

		if (!numbers.contains(randomNumber)) {
			return randomNumber;
		}

		return makeRandomNumber(numbers);
	}

	public long sameNumberLocation(BaseballNumber compareBaseBallNumber) {
		return baseballNumber.sameNumberLocation(compareBaseBallNumber);
	}

	public long containsNumber(BaseballNumber compareBaseballNumber) {
		return baseballNumber.containsNumber(compareBaseballNumber);
	}
}
