package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
	private final int MIN_NUM = 1;
	private final int MAX_NUM = 9;
	private final int ANSWER_SIZE = 3;
	public int[] number = {0, 0, 0};

	public void reset() {
		for (int i = 0; i < ANSWER_SIZE; i++) {
			number[i] = 0;
		}
	}

	public void chooseNumber() {
		reset();
		System.out.print("숫자를 입력해주세요 : ");
		String numberStr = Console.readLine();

		if (numberStr.length() != ANSWER_SIZE) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < ANSWER_SIZE; i++) {
			char charIdxNum = numberStr.charAt(i);

			if (!(charIdxNum - '0' >= MIN_NUM && charIdxNum - '0' <= MAX_NUM)) {
				throw new IllegalArgumentException();
			}

			if (!checkReduplication(charIdxNum - '0', i)) {
				throw new IllegalArgumentException();
			}

			number[i] = charIdxNum - '0';
		}
	}

	public boolean checkReduplication(int num, int idx) {
		for (int i = 0; i < idx; i++) {
			if (number[i] == num) {
				return false;
			}
		}
		return true;
	}
}
