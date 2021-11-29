package baseball.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private static final int MAX_NUMBER_SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private BaseballNumber baseballNumber;

	public Computer() {
		ArrayList<Integer> numbers = new ArrayList<>();

		while (numbers.size() < MAX_NUMBER_SIZE) {
			numbers.add(makeRandomNumber(numbers));
		}

		this.baseballNumber = new BaseballNumber(
			new ArrayList<>(numbers
				.stream()
				.map(Number::new)
				.collect(Collectors.toList()))
		);
		
	}

	private int makeRandomNumber(ArrayList<Integer> numbers) {
		int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

		if (!numbers.contains(randomNumber)) {
			return randomNumber;
		}

		return makeRandomNumber(numbers);
	}
}
