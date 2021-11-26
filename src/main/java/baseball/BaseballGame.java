package baseball;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseballGame {

	static final int START_NUMBER = 1;
	static final int END_NUMBER = 9;
	static final int ANSWER_LENGTH = 3; // 1 <= ANSWER_LENGTH <= END_NUMBER - START_NUMBER + 1

	public static boolean play() {
		String answer = makeAnswer();
		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = readLine();
			checkInput(input);
			int[] ballAndStrikeCount = countBallAndStrike(answer, input);
			boolean isAnswer = printBaseballGameResult(ballAndStrikeCount);
			if (isAnswer) {
				break;
			}
		}
		boolean finishBaseballGame = askFinishBaseballGame();
		return finishBaseballGame;
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
			if (!(number >= START_NUMBER && number <= END_NUMBER)) {
				throw new IllegalArgumentException();
			}
		}
	}

	public static int[] countBallAndStrike(String answer, String input) {
		int[] ballAndStrikeCount = new int[2];
		int ballCount = 0;
		int strikeCount = 0;
		int[] answerNumberCount = new int[END_NUMBER - START_NUMBER + 1];
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int answerNumber = answer.charAt(i) - '0';
			answerNumberCount[answerNumber - START_NUMBER]++;
		}
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int answerNumber = answer.charAt(i) - '0';
			int inputNumber = input.charAt(i) - '0';
			if (answerNumber == inputNumber) {
				strikeCount++;
			} else if (answerNumberCount[inputNumber - START_NUMBER] > 0) {
				ballCount++;
			}
		}
		ballAndStrikeCount[0] = ballCount;
		ballAndStrikeCount[1] = strikeCount;
		return ballAndStrikeCount;
	}

	public static boolean printBaseballGameResult(int[] ballAndStrikeCount) {
		boolean isAnswer = false;
		int ballCount = ballAndStrikeCount[0];
		int strikeCount = ballAndStrikeCount[1];
		if (strikeCount == ANSWER_LENGTH) {
			System.out.println(ANSWER_LENGTH + "스트라이크");
			System.out.println(ANSWER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
			isAnswer = true;
		} else if (ballCount > 0 && strikeCount > 0) {
			System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
		} else if (ballCount > 0) {
			System.out.println(ballCount + "볼");
		} else if (strikeCount > 0) {
			System.out.println(strikeCount + "스트라이크");
		} else {
			System.out.println("낫싱");
		}
		return isAnswer;
	}

	public static boolean askFinishBaseballGame() {
		boolean finishBaseballGame = true;
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String input = readLine();
		if (!(input.equals("1") || input.equals("2"))) {
			throw new IllegalArgumentException();
		}
		if (input.equals("1")) {
			finishBaseballGame = false;
		}
		return finishBaseballGame;
	}
}

