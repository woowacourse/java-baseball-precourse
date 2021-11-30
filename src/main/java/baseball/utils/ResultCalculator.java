package baseball.utils;

import java.util.HashSet;

public class ResultCalculator {

	private static final int BALL_NUMBERS_LENGTH = 3;
	private final char[] inputBallNumbers;
	private final char[] randomBallNumbers;
	private HashSet<Character> numberSet;
	private int ball;
	private int strike;

	public ResultCalculator(String inputBallNumbers, String randomBallNumbers) {
		this.inputBallNumbers = inputBallNumbers.toCharArray();
		this.randomBallNumbers = randomBallNumbers.toCharArray();

		ball = 0;
		strike = 0;

		setNumberSet();
	}

	public void calculateResults() {
		for (int i = 0; i < BALL_NUMBERS_LENGTH; i++) {
			calculateResult(this.inputBallNumbers[i], this.randomBallNumbers[i]);
		}
	}

	private void calculateResult(char inputNumber, char randomNumber) {
		if (isInNumberSet(inputNumber)) {
			if (isSamePlace(inputNumber, randomNumber)) {
				strike++;
			} else {
				ball++;
			}
		}
	}

	private boolean isInNumberSet(char inputNumber) {
		return numberSet.contains(inputNumber);
	}

	private boolean isSamePlace(char inputNumber, char randomNumber) {
		return inputNumber == randomNumber;
	}

	private void setNumberSet() {
		numberSet = new HashSet<>();
		for (char number : randomBallNumbers) {
			numberSet.add(number);
		}
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}
}
