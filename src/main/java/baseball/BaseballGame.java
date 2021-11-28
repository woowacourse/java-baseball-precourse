package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
	public static final int TARGET_SIZE = 3;
	private List<Integer> target;

	private int ballScore;
	private int strikeScore;
	private boolean isScoreNothing;

	protected void setNewTarget() {
		List<Integer> randomPicks = new ArrayList<>();
		while (randomPicks.size() < TARGET_SIZE) {
			int pick = Randoms.pickNumberInRange(1, 9);
			if (!randomPicks.contains(pick)) {
				randomPicks.add(pick);
			}
		}
		target = randomPicks;
		resetScore();
	}

	private void resetScore() {
		ballScore = 0;
		strikeScore = 0;
		isScoreNothing = false;
	}

	protected void judgeAndShowHint(List<Integer> guess) {
		resetScore();
		countBallScore(guess);
		countStrikeScore(guess);
		checkScoreNothing();
		System.out.println(buildHintString());
	}

	protected boolean isGuessEqualTarget() {
		if (strikeScore == TARGET_SIZE) {
			return true;
		} else {
			return false;
		}
	}

	private void countStrikeScore(List<Integer> guess) {
		for (int i = 0; i < TARGET_SIZE; i++) {
			if (guess.get(i) == target.get(i).intValue()) {
				strikeScore += 1;
			}
		}
	}

	private void countBallScore(List<Integer> guess) {
		for (int i = 0; i < TARGET_SIZE; i++) {
			if (guess.get(i) != target.get(i).intValue() && target.contains(guess.get(i))) {
				ballScore += 1;
			}
		}
	}

	private void checkScoreNothing() {
		if (ballScore == 0 && strikeScore == 0) {
			isScoreNothing = true;
		}
	}

	private String buildHintString() {
		StringBuilder stringBuilder = new StringBuilder();

		if (ballScore != 0) {
			stringBuilder.append(ballScore).append("볼");
		}

		if (ballScore != 0 && strikeScore != 0) {
			stringBuilder.append(" ");
		}

		if (strikeScore != 0) {
			stringBuilder.append(strikeScore).append("스트라이크");
		}

		if (isScoreNothing) {
			stringBuilder.append("낫싱");
		}

		return stringBuilder.toString();
	}
}
