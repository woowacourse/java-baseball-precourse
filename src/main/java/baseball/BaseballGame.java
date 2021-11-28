package baseball;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;
import static constants.BaseBallGameMessage.*;
import static constants.BaseballGameSetting.*;

public class BaseballGame {

	private String answer;
	private String userInput;
	private int ballCount;
	private int strikeCount;
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
		int ball = 0;
		int strike = 0;
		int[] answerNumberCount = new int[END_NUMBER - START_NUMBER + 1];
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int answerNumber = answer.charAt(i) - '0';
			answerNumberCount[answerNumber - START_NUMBER]++;
		}
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int answerNumber = answer.charAt(i) - '0';
			int inputNumber = userInput.charAt(i) - '0';
			if (answerNumber == inputNumber) {
				strike++;
			} else if (answerNumberCount[inputNumber - START_NUMBER] > 0) {
				ball++;
			}
		}
		ballCount = ball;
		strikeCount = strike;
	}

	private void printBaseballGameResult() {
		if (strikeCount == ANSWER_LENGTH) {
			System.out.println(ANSWER_LENGTH + STRIKE);
			System.out.println(END_MESSAGE);
		} else if (ballCount > 0 && strikeCount > 0) {
			System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
		} else if (ballCount > 0) {
			System.out.println(ballCount + BALL);
		} else if (strikeCount > 0) {
			System.out.println(strikeCount + STRIKE);
		} else {
			System.out.println(NOTHING);
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
