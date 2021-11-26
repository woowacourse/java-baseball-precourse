package baseball;

import static baseball.Rules.*;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	private int[] answer;
	private static boolean[] usedNumber;

	public void makeRandomNumber() {
		initAnswer();
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			answer[i] = makeUniqueNumber();
		}
	}

	private void initAnswer() {
		answer = new int[NUMBER_LENGTH];
		usedNumber = new boolean[END_NUMBER + 1];
	}

	private int makeUniqueNumber() {
		int randomNumber;
		do {
			randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
		} while (usedNumber[randomNumber]);
		usedNumber[randomNumber] = true;
		return randomNumber;
	}

	public int[] getAnswer() {
		return answer;
	}
}
