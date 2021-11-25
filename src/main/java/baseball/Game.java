package baseball;

public class Game {

	public static String play(String answer, String input) {

		String[] answerArray = answer.split("");
		String[] inputArray = input.split("");

		int strike = 0;
		int ball = 0;

		for (int i = 0; i < 3; i++) {

			String result = checkOneNumber(answerArray, inputArray[i], i);

			if (result.equals(Message.STRIKE)) {
				strike++;
			} else if (result.equals(Message.BALL)) {
				ball++;
			}
		}

		String message = makeMessage(strike, ball, "");

		return message;
	}

	private static String checkOneNumber(String[] answerArray, String number, int index) {

		for (int i = 0; i < 3; i++) {

			if (answerArray[i].equals(number) && index == i) {
				return Message.STRIKE;
			} else if (answerArray[i].equals(number)) {
				return Message.BALL;
			}
		}

		return Message.NOTHING;
	}

	private static String makeMessage(int strike, int ball, String message) {

		if (ball == 0 && strike == 0) {
			return Message.NOTHING;
		}

		if (ball > 0) {
			message += ball + Message.BALL + " ";
		}

		if (strike > 0) {
			message += strike + Message.STRIKE;
		}

		return message;
	}
}
