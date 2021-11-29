package baseball;

import java.util.Arrays;

public class BaseballGame {

	private String answer;
	private boolean isGameOngoing;

	BaseballGame() {
		answer = "";
		isGameOngoing = false;
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

	public void makeRandomBaseballGameAnswer() {

		if (isGameOngoing) {
			return;
		}
		answer = "";
		while (!checkBaseballGameAnswerFormatRules(answer)) {
			answer = Integer.toString(camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(111, 999));
		}
	}
}
