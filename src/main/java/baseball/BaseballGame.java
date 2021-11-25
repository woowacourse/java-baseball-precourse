package baseball;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseballGame {

	static final int START_NUMBER = 1;
	static final int END_NUMBER = 9;
	static final int ANSWER_LENGTH = 3; // 1 <= ANSWER_LENGTH <= END_NUMBER - START_NUMBER + 1

	public static boolean play() {
		String answer = makeAnswer();
		String input = readLine();
		try {
			checkInput(input);
		} catch (Exception execption) {
			System.exit(0);
		}
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

	public static void checkInput(String input) {
		if (input.length() != ANSWER_LENGTH) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int number = input.charAt(i) - '0';
			if (number >= START_NUMBER && number <= END_NUMBER) {
				continue;
			} else {
				throw new IllegalArgumentException();
			}
		}
	}
}
