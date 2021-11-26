package baseball.domain;

import java.util.Arrays;
import java.util.Collections;

public class Referee {
	private static int ball;
	private static int strike;

	public static void getJudgment(User user, Computer computer) {
		Integer[] answer = computer.getAnswer();
		Integer[] userExpectedAnswer = user.getExpectedAnswer();

		for (int i = 0; i < userExpectedAnswer.length; i++) {
			int findIndex = Arrays.asList(answer).indexOf(userExpectedAnswer[i]);
			if (i == findIndex) {
				strike++;
			} else if (findIndex > -1) {
				ball++;
			}

		}
	}

}
