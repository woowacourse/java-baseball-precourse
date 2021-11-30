package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
	private static final int MIN = 1;
	private static final int MAX = 9;
	private static final int NUMBER_LENGTH = 3;

	private static List<Integer> numberList;

	public static List<Integer> generateRandomNumber() {
		Set<Integer> uniqueNumbers = new HashSet<>();
		while (uniqueNumbers.size() < NUMBER_LENGTH) {
			uniqueNumbers.add(Randoms.pickNumberInRange(MIN, MAX));
		}

		numberList = new ArrayList<>(uniqueNumbers);
		return numberList;
	}
}
