package baseball;

import static baseball.Valid.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
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

	public int checkBallCount(List<Integer> userNumbers) {
		int ballCount = 0;
		for (int i = 0; i < 3; i++) {
			int userNumber = userNumbers.get(i);
			if (randomNumbers.contains(userNumber)
				&& userNumber != randomNumbers.get(i)) {
				ballCount++;
			}
		}
		return ballCount;
	}

	public int checkStrikeCount(List<Integer> userNumbers) {
		int strikeCount = 0;
		for (int i = 0; i < 3; i++) {
			int userNumber = userNumbers.get(i);
			if (userNumber == randomNumbers.get(i)) {
				strikeCount++;
			}
		}
		return strikeCount;
	}
}
