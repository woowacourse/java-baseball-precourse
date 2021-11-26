package baseball.domain;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final Integer BASEBALL_GAME_BALL_COUNT = 3;
	private static final Integer BASEBALL_GAME_NUMBER_RANGE_START = 1;
	private static final Integer BASEBALL_GAME_NUMBER_RANGE_END = 9;
	private static final Integer EMPTY_NUMBER = -1;

	private int[] randomNumbers;

	public void createRandomNumbers() {
		initiateEmptyRandomNumbers();
		do {
			int number = Randoms.pickNumberInRange(BASEBALL_GAME_NUMBER_RANGE_START, BASEBALL_GAME_NUMBER_RANGE_END);
			insertNumberToRandomNumbers(number, getNextIndexRandomNumbers());
		} while (getNextIndexRandomNumbers() < BASEBALL_GAME_BALL_COUNT);
	}

	private void initiateEmptyRandomNumbers() {
		randomNumbers = new int[BASEBALL_GAME_BALL_COUNT];
		for (int i = 0; i < BASEBALL_GAME_BALL_COUNT; i++) {
			randomNumbers[i] = EMPTY_NUMBER;
		}
	}

	private Integer getNextIndexRandomNumbers() {
		for (int i = 0; i < BASEBALL_GAME_BALL_COUNT; i++) {
			if (randomNumbers[i] == EMPTY_NUMBER) {
				return i;
			}
		}
		return BASEBALL_GAME_BALL_COUNT;
	}

	private void insertNumberToRandomNumbers(int number, int index) {
		if (isNewNumber(number)) {
			randomNumbers[index] = number;
		}
	}

	private Boolean isNewNumber(int number) {
		return !Arrays.stream(randomNumbers).anyMatch(randomNumber -> randomNumber == number);
	}
}
