package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	public List<Integer> createRandomNumbers() {
		List<Integer> computerNumbers = new ArrayList<>();
		int count = 0;
		while (count < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (computerNumbers.contains(randomNumber)) {
				continue;
			}
			computerNumbers.add(randomNumber);
			count++;
		}
		return computerNumbers;
	}
}
