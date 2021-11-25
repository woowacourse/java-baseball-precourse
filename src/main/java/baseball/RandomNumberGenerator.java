package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	private int[] answer = new int[Rules.NUMBER_LENGTH];
	private static boolean[] usedNumber = new boolean[Rules.END_NUMBER + 1];

	public void makeRandomNumber() {
		for (int i = 0; i < Rules.NUMBER_LENGTH; i++) {
			answer[i] = makeUniqueNumber();
		}
	}

	private int makeUniqueNumber() {
		int randomNumber;
		do {
			randomNumber = Randoms.pickNumberInRange(Rules.START_NUMBER, Rules.END_NUMBER);
		} while (usedNumber[randomNumber]);
		usedNumber[randomNumber] = true;
		return randomNumber;
	}

	public int[] getAnswer() {
		return answer;
	}
}
