package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
	private final int MIN_NUM = 1;
	private final int MAX_NUM = 9;
	private final int ANSWER_SIZE;
	private boolean[] flag;
	public int[] number;

	public User(int answerSize) {
		ANSWER_SIZE = answerSize;
		number = new int[answerSize];
		flag = new boolean[MAX_NUM + 1];
		for (int i = 0; i < answerSize; i++) {
			number[i] = 0;
		}
		for (int i = 0; i < MAX_NUM + 1; i++) {
			flag[i] = false;
		}
	}

	public void reset() {
		for (int i = 0; i < ANSWER_SIZE; i++) {
			number[i] = 0;
		}
		for (int i = 0; i < MAX_NUM + 1; i++) {
			flag[i] = false;
		}
	}

	public void chooseNumber() {
		reset();

		System.out.print("숫자를 입력해주세요 : ");
		String numberStr = Console.readLine();

		checkException(numberStr);
	}

	public void checkException(String numberStr) {
		if (!checkSize(numberStr)) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < ANSWER_SIZE; i++) {
			char charIdxNum = numberStr.charAt(i);

			if (!checkNumber(charIdxNum)) {
				throw new IllegalArgumentException();
			}

			if (!checkReduplication(charIdxNum - '0')) {
				throw new IllegalArgumentException();
			}

			number[i] = charIdxNum - '0';
		}
	}

	public boolean checkSize(String numberStr) {
		if (numberStr.length() != ANSWER_SIZE) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkNumber(char charIdxNum) {
		if (!(charIdxNum - '0' >= MIN_NUM && charIdxNum - '0' <= MAX_NUM)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkReduplication(int num) {
		if (flag[num]) {
			return false;
		} else {
			flag[num] = true;
			return true;
		}
	}
}
