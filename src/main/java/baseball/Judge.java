package baseball;

public class Judge {
	public static boolean isCorrect(String rightAnswer, String userInput, int length) {
		int ball = 0, strike = 0;
		for (int i = 0; i < length; i++) {
			if (Judge.isBall(rightAnswer, userInput.charAt(i), i)) {
				ball += 1;
			} else if (Judge.isStrike(rightAnswer, userInput.charAt(i), i)) {
				strike += 1;
			}
		}
		Output.printResult(ball, strike);

		if (strike == length) { // 정답을 맞힌 경우
			return true;
		}
		return false;
	}

	private static boolean isBall(String rightAnswer, char num, int idx) {
		for (int i = 0; i < rightAnswer.length(); i++) {
			if (i == idx) {
				continue;
			}
			if (rightAnswer.charAt(i) == num) {
				return true;
			}
		}
		return false;
	}

	private static boolean isStrike(String rightAnswer, char num, int idx) {
		if (rightAnswer.charAt(idx) == num) {
			return true;
		}
		return false;
	}
}
