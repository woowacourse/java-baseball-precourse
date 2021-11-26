package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int NUMBER_LENGTH = 3;
	private int[] answer;

	public Computer() {
		answer = new int[NUMBER_LENGTH];
	}

	public void generateAnswer() {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			answer[i] = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		}
	}
}
