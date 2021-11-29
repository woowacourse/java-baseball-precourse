package baseball.domain;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
	public static final int PICK_NUMBER = 3;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;

	public static ArrayList<Integer> getRandomNumbers() {
		ArrayList<Integer> randomNumbers = new ArrayList<>();
		while (randomNumbers.size() < PICK_NUMBER) {
			int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (!randomNumbers.contains(number)) {
				randomNumbers.add(number);
			}
		}
		return randomNumbers;
	}

}
