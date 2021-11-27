package baseball.domain;

import java.util.List;

import baseball.type.NumberRangeType;

public class Result {

	private int strike;
	private int ball;

	public Result(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		checkBallCount(computerNumbers, playerNumbers);
		checkStrikeCount(computerNumbers, playerNumbers);
	}

	public void checkStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		for (int index = 0; index < NumberRangeType.ANSWER_SIZE.getNumberRange(); index++) {
			if (computerNumbers.get(index) == playerNumbers.get(index)) {
				strike++;
				ball--;
			}
		}
	}

	public void checkBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		for (Integer playerNumber : playerNumbers) {
			if (computerNumbers.contains(playerNumber))
				ball++;
		}
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
