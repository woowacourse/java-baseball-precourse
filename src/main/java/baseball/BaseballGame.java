package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {

	private static final String NEW_GAME = "1";
	private static final String QUIT = "2";
	private static final String QUESTION_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String MESSAGE_ABOUT_WRONG_INPUT = "잘못된 입력입니다.";
	private static final String HINT_BALL_MESSAGE = "%d볼 ";
	private static final String HINT_STRIKE_MESSAGE = "%d스트라이크";
	private static final String HINT_NOTHING_MESSAGE = "낫싱";
	private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String CHECK_KEEP_GOING_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final int START_INCLUSIVE = 1;
	private static final int END_INCLUSIVE = 9;
	private static final int LENGTH_OF_ANSWER = 3;
	private static List<Integer> answerNumber;
	private static boolean not_three_strike = true;
	private final Player player;

	public BaseballGame() {
		player = new Player();
		startGame();
		endGame();
	}

	private void startGame() {
		String playerNumber;
		answerNumber = setAnswerNumber();
		while (not_three_strike) {
			System.out.print(QUESTION_MESSAGE);
			playerNumber = player.enterTheAnswer();
			checkAnswer(playerNumber);
		}
	}

	private void endGame() {
		String playerAnswer;
		System.out.println(GAME_END_MESSAGE);
		System.out.println(CHECK_KEEP_GOING_MESSAGE);
		playerAnswer = player.enterTheAnswer();
		askPlayGameAgain(playerAnswer);
	}

	private List<Integer> setAnswerNumber() {
		Set<Integer> createAnswerNumber = new LinkedHashSet<>();
		while (createAnswerNumber.size() < LENGTH_OF_ANSWER) {
			createAnswerNumber.add(pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
		}
		return new ArrayList<>(createAnswerNumber);
	}

	private void checkAnswer(String playerNumber) {
		validateInputs(playerNumber);
		int[] ballAndStrike = compareNumber(playerNumber);
		if (ballAndStrike[1] == LENGTH_OF_ANSWER) {
			System.out.printf(HINT_STRIKE_MESSAGE + '\n', ballAndStrike[1]);
			not_three_strike = false;
			return;
		}
		System.out.println(printHintMessage(ballAndStrike[0], ballAndStrike[1]));
	}

	private String printHintMessage(int ballNumber, int strikeNumber) {
		String hintMessage = "";
		if (ballNumber > 0) {
			hintMessage += String.format(HINT_BALL_MESSAGE, ballNumber);
		}
		if (strikeNumber > 0) {
			hintMessage += String.format(HINT_STRIKE_MESSAGE, strikeNumber);
		}
		if (hintMessage.equals("")) {
			hintMessage += HINT_NOTHING_MESSAGE;
		}
		return hintMessage;
	}

	private int[] compareNumber(String playerNumber) {
		int ballNumber = 0;
		int strikeNumber = 0;
		for (int i = 0; i < 3; i++) {
			strikeNumber += countStrikeNumber(answerNumber.get(i), Character.getNumericValue(playerNumber.charAt(i)));
			ballNumber += countBallNumber(i, Character.getNumericValue(playerNumber.charAt(i)));
		}
		return new int[] {ballNumber, strikeNumber};
	}

	private int countStrikeNumber(int answerNumber, int playerNumber) {
		if (answerNumber == playerNumber) {
			return 1;
		}
		return 0;
	}

	private int countBallNumber(int nthOrder, int playerNumber) {
		if (answerNumber.contains(playerNumber) && answerNumber.get(nthOrder) != playerNumber) {
			return 1;
		}
		return 0;
	}

	private void askPlayGameAgain(String playerNumber) {
		if (!playerNumber.equals(NEW_GAME) && !playerNumber.equals(QUIT)) {
			throw new IllegalArgumentException(MESSAGE_ABOUT_WRONG_INPUT);
		}
		if (playerNumber.equals(NEW_GAME)) {
			not_three_strike = true;
			startGame();
		}
	}

	private void validateInputs(String playNumber) {
		checkWrongType(playNumber);
		checkDuplicated(playNumber);
		checkWrongRange(playNumber);
	}

	private void checkWrongType(String playerNumber) {
		boolean isNumeric = playerNumber.matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) {
			throw new IllegalArgumentException(MESSAGE_ABOUT_WRONG_INPUT);
		}
	}

	private void checkDuplicated(String playerNumber) {
		HashSet<String> numbersWithNoDuplicates = new HashSet<>(Arrays.asList(playerNumber.split("")));
		if (numbersWithNoDuplicates.size() != LENGTH_OF_ANSWER) {
			throw new IllegalArgumentException(MESSAGE_ABOUT_WRONG_INPUT);
		}
	}

	private void checkWrongRange(String playerNumber) {
		if (playerNumber.length() != LENGTH_OF_ANSWER) {
			throw new IllegalArgumentException(MESSAGE_ABOUT_WRONG_INPUT);
		}
	}

}
