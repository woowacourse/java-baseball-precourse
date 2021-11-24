package domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Numbers {

	private static final int NUMBERS_SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final List<Number> numbers;

	public Numbers() {
		this.numbers = generateRandomNumbers();
	}

	private List<Number> generateRandomNumbers() {
		List<Number> generatedNumbers = new ArrayList<Number>();
		while (generatedNumbers.size() < NUMBERS_SIZE) {
			Number nextNumber = new Number(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			if (!generatedNumbers.contains(nextNumber)) {
				generatedNumbers.add(nextNumber);
			}
		}

		return generatedNumbers;
	}

}
