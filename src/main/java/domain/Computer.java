package domain;

import java.util.Random;

public class Computer {
	private static final int LEN_NUMBERS = 3;
	private static final int NUM_RANGE = 9;
	private static final int NUM_MIN = 1;
	private static final int GAMEOVER_COUNTS = 3;
	private static final int NUMBER_BEFORE_GENERATE = -1;
	
	private int numbers[];

	public Computer() {
		numbers = new int[LEN_NUMBERS];
		for (int i = 0; i < LEN_NUMBERS; i++) {
			numbers[i] = NUMBER_BEFORE_GENERATE;
		}
	}

	public void printNumbers() {
		System.out.print("generated numbers are: ");
		for (int i = 0; i < LEN_NUMBERS; i++) {
			System.out.print(numbers[i]);
		}
		System.out.print("\n");
	}

	public void generateNumbers() {
		for (int i = 0; i < LEN_NUMBERS; i++) {
			numbers[i] = generateUnoverlappedNumber();
		}
	}

	private int generateUnoverlappedNumber() {
		int newRandomNumber;

		do {
			newRandomNumber = generateRandomNumber();
		} while (isThereSameNumber(newRandomNumber));

		return newRandomNumber;
	}

	private boolean isThereSameNumber(int newNum) {
		for (int i = 0; i < LEN_NUMBERS; i++) {
			if (numbers[i] == newNum) {
				return true;
			}
		}

		return false;
	}

	private int generateRandomNumber() {
		Random randGenerator = new Random();
		return randGenerator.nextInt(NUM_RANGE) + NUM_MIN;
	}

	public void printGameResult(int[] userNumbers) {
		int strikeCounts = getStrikeCounts(userNumbers);
		int ballCounts = getBallCounts(userNumbers);

		if (strikeCounts != 0) {
			System.out.print(strikeCounts + " 스트라이크 ");
		}
		if (ballCounts != 0) {
			System.out.print(ballCounts + "볼");
		}
		if (strikeCounts == 0 && ballCounts == 0) {
			System.out.print("낫싱");
		}
		System.out.print("\n");
	}

	private int getStrikeCounts(int[] userNumbers) {
		int strikeCounts = 0;

		for (int i = 0; i < LEN_NUMBERS; i++) {
			if (userNumbers[i] == numbers[i]) {
				strikeCounts++;
			}
		}

		return strikeCounts;
	}

	private int getBallCounts(int[] userNumbers) {
		int ballCounts = 0;

		for (int i = 0; i < LEN_NUMBERS; i++) {
			if (isThereSameNumber(userNumbers[i])) {
				ballCounts++;
			}
		}

		ballCounts -= getStrikeCounts(userNumbers);

		return ballCounts;
	}

	public boolean isGameOver(int[] userNumbers) {
		if (getStrikeCounts(userNumbers) == GAMEOVER_COUNTS) {
			return true;
		}

		return false;
	}
}
