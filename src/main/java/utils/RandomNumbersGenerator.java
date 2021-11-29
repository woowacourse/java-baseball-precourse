package utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbersGenerator {
	private static final int MAX_NUMBER = 9;
	private static final int MIN_NUMBER = 1;
	private static final int NUMBER_SIZE = 3;

	private RandomNumbersGenerator() {
	}

	public static int[] makeThreeRandomNumbers() {
		List<Integer> randomNumbers = new ArrayList<>(NUMBER_SIZE);

		while (randomNumbers.size() < NUMBER_SIZE) {
			int randomNumber = makeRandomNumber();
			if (!randomNumbers.contains(randomNumber)) {
				randomNumbers.add(randomNumber);
			}
		}

		return randomNumbers.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int makeRandomNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
}
