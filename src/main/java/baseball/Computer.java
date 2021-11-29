package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	public ArrayList<Integer> numberGenerator() {
		ArrayList<Integer> computerNumbers = new ArrayList<Integer>();
		computerNumbers = RandomGenerator();
		return computerNumbers;
	}

	public ArrayList<Integer> RandomGenerator() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		while (numbers.size() < 3) {
			int tmpRandomNumber = Randoms.pickNumberInRange(1, 9);
			if (numbers.contains(tmpRandomNumber)) {
				continue;
			} else {
				numbers.add(tmpRandomNumber);
			}
		}
		return numbers;
	}
}
