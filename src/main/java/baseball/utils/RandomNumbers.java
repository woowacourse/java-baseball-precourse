package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbers {
	private static final int START_INCLUSIVE = 1;
	private static final int END_INCLUSIVE = 9;
	private static final int NUM_OF_DIGIT = 3;

	public RandomNumbers(){};

	public static List<Integer> getRandomNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < NUM_OF_DIGIT; i++) {
			numbers.add(getNotDuplicateNum(numbers));
		}
		return numbers;
	}

	private static Integer getNotDuplicateNum(List<Integer> numbers) {
		Integer number;
		do {
			number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		}while(numbers.contains(number));

		return number;
	}
}
