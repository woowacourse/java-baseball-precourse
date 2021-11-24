package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> randomNumbers;

	public Computer() {}

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
