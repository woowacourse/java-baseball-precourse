package baseball.domain;

import java.util.Arrays;

public class Hint {
	private final Integer BASEBALL_GAME_BALL_COUNT = 3;
	private final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크";
	private final String BALL_MESSAGE = "%d볼";
	private final String STRIKE_MESSAGE = "%d스트라이크";
	private final String NOTHING_MESSAGE = "낫싱";
	private final int ZERO_COUNT = 0;

	private int strikeCounts;
	private int ballCounts;

	public Hint(int[] answer, int[] randomNumbers) {
		createStrikeHint(answer, randomNumbers);
		createBallHint(answer, randomNumbers);
	}

	private void createStrikeHint(int[] answer, int[] randomNumbers) {
		strikeCounts = 0;
		for (int i = 0; i < BASEBALL_GAME_BALL_COUNT; i++) {
			if (answer[i] == randomNumbers[i]) {
				strikeCounts++;
			}
		}
	}

	private void createBallHint(int[] answer, int[] randomNumbers) {
		ballCounts = 0;
		for (int i = 0; i < BASEBALL_GAME_BALL_COUNT; i++) {
			int number = answer[i];
			if (Arrays.stream(randomNumbers).anyMatch(randomNumber -> randomNumber == number)
				&& randomNumbers[i] != number) {
				ballCounts++;
			}
		}
	}

	public String hintMessage() {
		if (ballCounts == ZERO_COUNT && strikeCounts == ZERO_COUNT) {
			return NOTHING_MESSAGE;
		}
		if (ballCounts == ZERO_COUNT) {
			return String.format(STRIKE_MESSAGE, strikeCounts);
		}
		if (strikeCounts == ZERO_COUNT) {
			return String.format(BALL_MESSAGE, ballCounts);
		}
		return String.format(BALL_AND_STRIKE_MESSAGE, ballCounts, strikeCounts);
	}

	public Boolean isCorrect() {
		if (strikeCounts == BASEBALL_GAME_BALL_COUNT) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
