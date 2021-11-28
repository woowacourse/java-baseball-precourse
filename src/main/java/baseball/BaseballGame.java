package baseball;

import static baseball.BaseballGameSetting.*;
import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseballGame {

	private String answer;
	private String userInput;
	private int ball;
	private int strike;
	private boolean startBaseballGame = true;

	public void play() {
		while (startBaseballGame) {
			answer = makeAnswer();
			userInput = "";
			while (!answer.equals(userInput)) {
				System.out.print(INPUT_MESSAGE);
				userInput = readLine();
				checkUserInput();
				countBallAndStrike();
				printBaseballGameResult();
			}
			startBaseballGame = askRestartBaseballGame();
		}
	}

	private String makeAnswer() {
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

	private void checkUserInput() {
		checkUserInputLength();
		checkUserInputContents();
		checkUserInputDuplication();
	}

	private void checkUserInputLength() {
		if (userInput.length() != ANSWER_LENGTH) {
			throw new IllegalArgumentException();
		}
	}

	private void checkUserInputContents() {
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int content = userInput.charAt(i) - '0';
			if (!(content >= START_NUMBER && content <= END_NUMBER)) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void checkUserInputDuplication() {
		int[] duplicationCheckArray = new int[END_NUMBER - START_NUMBER + 1];
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int number = userInput.charAt(i) - '0';
			duplicationCheckArray[number - START_NUMBER]++;
			if (duplicationCheckArray[number - START_NUMBER] != 1) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void countBallAndStrike() {
		int ballCount = 0;
		int strikeCount = 0;
		int[] answerNumberCount = new int[END_NUMBER - START_NUMBER + 1];
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int answerNumber = answer.charAt(i) - '0';
			answerNumberCount[answerNumber - START_NUMBER]++;
		}
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int answerNumber = answer.charAt(i) - '0';
			int inputNumber = userInput.charAt(i) - '0';
			if (answerNumber == inputNumber) {
				strikeCount++;
			} else if (answerNumberCount[inputNumber - START_NUMBER] > 0) {
				ballCount++;
			}
		}
		ball = ballCount;
		strike = strikeCount;
	}

	private void printBaseballGameResult() {
		if (strike == ANSWER_LENGTH) {
			System.out.println(ANSWER_LENGTH + "스트라이크");
			System.out.println(END_MESSAGE);
		} else if (ball > 0 && strike > 0) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		} else if (ball > 0) {
			System.out.println(ball + "볼");
		} else if (strike > 0) {
			System.out.println(strike + "스트라이크");
		} else {
			System.out.println("낫싱");
		}
	}

	private boolean askRestartBaseballGame() {
		boolean restartBaseballGame = true;
		System.out.println(RESTART_MESSAGE);
		String userChoice = readLine();
		if (!START_OPTIONS.contains(userChoice)) {
			throw new IllegalArgumentException();
		}
		if (userChoice.equals(RESTART_OPTION)) {
			restartBaseballGame = true;
		}
		if (userChoice.equals(FINISH_OPTION)) {
			restartBaseballGame = false;
		}
		return restartBaseballGame;
	}
}
