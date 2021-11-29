package baseball;

import java.util.HashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker {

	private static final int RANDOM_START_INCLUSIVE = 1;
	private static final int RANDOM_END_INCLUSIVE = 9;
	private static final int BALL_NUMBERS_LENGTH = 3;
	private String randomBallNumbers;
	private HashSet<Integer> randomBallNumbersSet;

	public int pickOneRandomNumber() {
		return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
	}

	public void setRandomBallNumbers() {
		StringBuilder stringBuilder = new StringBuilder();
		randomBallNumbersSet = new HashSet<>();
		while (stringBuilder.length() < BALL_NUMBERS_LENGTH) {
			int number = pickOneRandomNumber();
			if (checkRandomBallNumberDuplicate(number)) {
				stringBuilder.append(number);
			}
		}
		randomBallNumbers = stringBuilder.toString();
	}

	public boolean checkRandomBallNumberDuplicate(int number) {
		if (randomBallNumbersSet.contains(number)) {
			return false;
		} else {
			randomBallNumbersSet.add(number);
			return true;
		}
	}

	public String getRandomBallNumbers() {
		return randomBallNumbers;
	}
}
