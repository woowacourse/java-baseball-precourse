package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	public int[] answer = {0, 0, 0};

	public void makeAnswer() {
		for (int i = 0; i < 3; i++) {
			int num = Randoms.pickNumberInRange(1, 9);

			if (checkReduplication(num)) {
				answer[i] = num;
			} else {
				i--;
			}
		}
	}

	public boolean checkReduplication(int num) {
		for (int i = 0; i < 3; i++) {
			if (answer[i] == num) {
				return false;
			}
		}
		return true;
	}

}
