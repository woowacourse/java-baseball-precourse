package baseball;

import java.util.Arrays;

public class BaseballGame {

	private String answer;
	private String guessAnswer;
	private boolean isGameOngoing;

	BaseballGame() {
		answer = "";
		guessAnswer = "";
		isGameOngoing = false;
	}

	public boolean playBaseballGameWithComputer(Player player) {
		makeRandomBaseballGameAnswer();
		isGameOngoing = true;
		while (!getBaseballGameHint().equals(BaseballGameConstants.END_CONDITION)) {
			askBaseballGameAnswerToPlayer(player);
		}
		isGameOngoing = false;
		return askPlayerContinueGame(player);
	}

	private void makeRandomBaseballGameAnswer() {
		if (isGameOngoing) {
			return;
		}
		answer = "";
		while (!checkBaseballGameAnswerFormatRules(answer)) {
			answer = Integer.toString(camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(111, 999));
		}
	}

	private String getBaseballGameHint() {
		if (answer.isEmpty() || guessAnswer.isEmpty()) {
			return "error";
		}
		int strikeNum = checkStrikeNum();
		int ballNum = checkBallNum();
		if (strikeNum == 0 && ballNum == 0) {
			return "낫싱";
		} else if (strikeNum == 0) {
			return ballNum + "볼";
		} else if (ballNum == 0) {
			return strikeNum + "스트라이크";
		}
		return ballNum + "볼 " + strikeNum + "스트라이크";
	}

	private void askBaseballGameAnswerToPlayer(Player player) throws IllegalArgumentException {
		guessAnswer = player.askQuestionAndGetAnswer(BaseballGameConstants.QUESTION_ASK_ANSWER);
		if (!checkBaseballGameAnswerFormatRules(guessAnswer)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean askPlayerContinueGame(Player player) throws IllegalArgumentException {
		String reply = player.askQuestionAndGetAnswer(BaseballGameConstants.QUESTION_ASK_CONTINUE_GAME);
		if (reply.equals("1")) {
			return true;
		} else if (reply.equals("2")) {
			return false;
		}
		throw new IllegalArgumentException();
	}

	private boolean checkLengthIsThree(String answer) {
		return answer.length() == BaseballGameConstants.LENGTH_RULE;
	}

	private boolean checkConsistOfOneToNine(String answer) {
		for (int index = 0; index < BaseballGameConstants.LENGTH_RULE; ++index) {
			char charAtIndex = answer.charAt(index);
			if (charAtIndex < '1' || charAtIndex > '9') {
				return false;
			}
		}
		return true;
	}

	private int convertCharToInt(char targetChar) {
		return targetChar - '0';
	}

	private boolean checkNoOverlapCharacter(String answer) {
		boolean[] isNumUsed = new boolean[10];
		Arrays.fill(isNumUsed, false);
		for (int index = 0; index < BaseballGameConstants.LENGTH_RULE; ++index) {
			int intAtIndex = convertCharToInt(answer.charAt(index));
			if (isNumUsed[intAtIndex]) {
				return false;
			}
			isNumUsed[intAtIndex] = true;
		}
		return true;
	}

	private boolean checkBaseballGameAnswerFormatRules(String answer) {
		return checkLengthIsThree(answer)
			&& checkConsistOfOneToNine(answer)
			&& checkNoOverlapCharacter(answer);
	}

	private int checkStrikeNum() {
		int strikeNum = 0;
		for (int index = 0; index < BaseballGameConstants.LENGTH_RULE; ++index) {
			if (answer.charAt(index) == guessAnswer.charAt(index)) {
				++strikeNum;
			}
		}
		return strikeNum;
	}

	private int returnOneIfCharInAnswerElseZero(String answer, char specificChar) {
		for (int index = 0; index < BaseballGameConstants.LENGTH_RULE; ++index) {
			if (answer.charAt(index) == specificChar) {
				return 1;
			}
		}
		return 0;
	}

	private int checkBallNum() {
		int ballNum = 0;
		for (int index = 0; index < BaseballGameConstants.LENGTH_RULE; ++index) {
			if (answer.charAt(index) != guessAnswer.charAt(index)) {
				ballNum += returnOneIfCharInAnswerElseZero(answer, guessAnswer.charAt(index));
			}
		}
		return ballNum;
	}
}
