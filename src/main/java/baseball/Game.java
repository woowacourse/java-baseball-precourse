package baseball;

import static constant.Constant.*;

public class Game {

	public static String play(String answer, String input) {

		String[] answerArray = answer.split("");
		String[] inputArray = input.split("");

		int strike = 0;
		int ball = 0;

		for (int i = 0; i < INPUT_LENGTH; i++) {

			String result = checkOneNumber(answerArray, inputArray[i], i);

			if (result.equals(STRIKE)) {
				strike++;
			} else if (result.equals(BALL)) {
				ball++;
			}
		}

		String message = makeMessage(strike, ball, "");

		return message;
	}

	private static String checkOneNumber(String[] answerArray, String number, int index) {

		for (int i = 0; i < INPUT_LENGTH; i++) {

			if (answerArray[i].equals(number) && index == i) {
				return STRIKE;
			} else if (answerArray[i].equals(number)) {
				return BALL;
			}
		}

		return NOTHING;
	}

	private static String makeMessage(int strike, int ball, String message) {

		if (ball == 0 && strike == 0) {
			return NOTHING;
		}

		if (ball > 0) {
			message += ball + BALL + " ";
		}

		if (strike > 0) {
			message += strike + STRIKE;
		}

		return message;
	}
}
