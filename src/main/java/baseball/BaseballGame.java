package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
	public static final int TARGET_SIZE = 3;
	private List<Integer> target = new ArrayList<>(TARGET_SIZE);

	private int ballScore;
	private int strikeScore;
	private boolean isScoreNothing;

	private void setNewTarget() {
		target = Randoms.pickUniqueNumbersInRange(1, 9, TARGET_SIZE);
	}

	private void resetScore() {
		ballScore = 0;
		strikeScore = 0;
		isScoreNothing = false;
	}

	public void judge(List<Integer> guess) {
		resetScore();
		countBallScore(guess);
		countStrikeScore(guess);
		checkScoreNothing();
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

	protected int getBallScore() {
		return ballScore;
	}

	protected int getStrikeScore() {
		return strikeScore;
	}

	protected boolean getIsScoreNothing() {
		return isScoreNothing;
	}
}
