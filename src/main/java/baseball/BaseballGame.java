package baseball;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseballGame {

	private final int START_NUMBER = 1; // 1 <= START_NUMBER <= 9
	private final int END_NUMBER = 9; // START_NUMBER <= END_NUMBER <= 9
	private final int ANSWER_LENGTH = 3; // 1 <= ANSWER_LENGTH <= END_NUMBER - START_NUMBER + 1
	private final String RESTART_OPTION = "1";
	private final String FINISH_OPTION = "2";
	private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
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
				initializeBallAndStrike();
				System.out.print(INPUT_MESSAGE);
				userInput = readLine();
				checkInput();
				countBallAndStrike();
				printBaseballGameResult();
			}
			askRestartBaseballGame();
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

	private void initializeBallAndStrike() {
		ball = 0;
		strike = 0;
	}

	private void checkInput() {
		if (userInput.length() != ANSWER_LENGTH) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < ANSWER_LENGTH; i++) {
			int number = userInput.charAt(i) - '0';
			if (!(number >= START_NUMBER && number <= END_NUMBER)) {
				throw new IllegalArgumentException();
			}
		}
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
	}

	private void printBaseballGameResult() {
		if (strike == ANSWER_LENGTH) {
			System.out.println(ANSWER_LENGTH + "스트라이크");
			System.out.println(ANSWER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
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

	private void askRestartBaseballGame() {
		System.out.println(RESTART_MESSAGE);
		String userChoice = readLine();
		if (!(userChoice.equals(RESTART_OPTION) || userChoice.equals(FINISH_OPTION))) {
			throw new IllegalArgumentException();
		}
		if (userChoice.equals(RESTART_OPTION)) {
			startBaseballGame = true;
		}
		if (userChoice.equals(FINISH_OPTION)) {
			startBaseballGame = false;
		}
	}
}
