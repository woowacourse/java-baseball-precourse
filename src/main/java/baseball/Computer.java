package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	public static final int NUMBER_SIZE = 3;
	public static final int DIGIT = 10;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;

	public int[] randomNumber = new int[NUMBER_SIZE];

	public void makeRandomNumber() {
		boolean[] isUsed = new boolean[DIGIT];
		int currentIndex = 0;
		while (currentIndex < NUMBER_SIZE) {
			int eachNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (!isUsed[eachNumber]) {
				randomNumber[currentIndex] = eachNumber;
				isUsed[eachNumber] = true;
				currentIndex++;
			}
		}
	}
}
