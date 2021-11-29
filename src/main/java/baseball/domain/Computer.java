package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	public static final int ZERO = 0;
	public static final int LIMITED_LENGTH = 3;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;

	public List<Integer> createRandomNumbers() {
		List<Integer> computerNumbers = new ArrayList<>();
		int count = ZERO;
		while (count < LIMITED_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (computerNumbers.contains(randomNumber)) {
				continue;
			}
			computerNumbers.add(randomNumber);
			count++;
		}
		return computerNumbers;
	}
}
