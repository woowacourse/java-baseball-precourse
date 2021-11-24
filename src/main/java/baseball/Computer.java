package baseball;

import static baseball.Valid.validateNumbersList;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final boolean VALID_FAILED = false;
	private List<Integer> randomNumbers;

	public Computer() {}

	public void init() {
		do {
			setNewRandomNumbers();
		} while (validateNumbersList(randomNumbers) == VALID_FAILED);
	}

	public void setNewRandomNumbers() {
		randomNumbers = new ArrayList<>();
		while (randomNumbers.size() < 3) {
			int number = Randoms.pickNumberInRange(1, 9);
			if (!randomNumbers.contains(number)) {
				randomNumbers.add(number);
			}
		}
	}
}
