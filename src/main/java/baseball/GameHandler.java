package baseball;

public class GameHandler {
	static final int MIN_NUM = 1;
	static final int MAX_NUM = 9;
	static final int INPUT_LEN = 3;
	static final int RESTART = 1;
	static final int TERMINATE = 2;
	static final int END_INPUT_LEN = 1;

	public static boolean oneRound() {
		String rightAnswer = Util.randomNumberGenerator(MIN_NUM, MAX_NUM, INPUT_LEN);
		boolean isCorrect = false;

		while (isCorrect == false) {
			isCorrect = oneTry(rightAnswer);
		}

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		if (isRestart()) {
			return true;
		}
		return false;
	}

	public static boolean oneTry(String rightAnswer) {
		String userInput = Input.getNumber(
			"숫자를 입력해주세요 : ",
			MIN_NUM, MAX_NUM, INPUT_LEN);

		if (Judge.isCorrect(rightAnswer, userInput, INPUT_LEN)) {
			return true;
		}
		return false;
	}

	private static boolean isRestart() {
		String input = Input.getNumber(
			"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n",
			RESTART, TERMINATE, END_INPUT_LEN);
		if (input.equals(RESTART + "")) {
			return true;
		}
		return false;
	}
}
