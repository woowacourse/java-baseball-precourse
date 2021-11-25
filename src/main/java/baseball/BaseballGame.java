package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseballGame {

	static final int START_NUMBER = 1;
	static final int END_NUMBER = 9;
	static final int ANSWER_LENGTH = 3;

	public static boolean play() {
		String answer = makeAnswer();

		return false;
	}

	public static String makeAnswer() {
		int[] duplicationCheckArray = new int[END_NUMBER - START_NUMBER + 1];
		String answer = "";
		while (answer.length() < ANSWER_LENGTH) {
			int randomNumber = pickNumberInRange(START_NUMBER, END_NUMBER);
			if (duplicationCheckArray[randomNumber - START_NUMBER] == 0) {
				answer += Integer.toString(randomNumber);
				duplicationCheckArray[randomNumber - START_NUMBER] = 1;
			}
		}
		return answer;
	}
}
