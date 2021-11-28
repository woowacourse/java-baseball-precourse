package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
	public int[] number = {0, 0, 0};

	public void reset() {
		for (int i = 0; i < 3; i++) {
			number[i] = 0;
		}
	}

	public void chooseNumber() {
		reset();
		System.out.print("숫자를 입력해주세요 : ");
		String numberStr = Console.readLine();

		if (numberStr.length() != 3) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < 3; i++) {
			char charIdxNum = numberStr.charAt(i);

			if (!(charIdxNum - '0' >= 1 && charIdxNum - '0' <= 9)) {
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
