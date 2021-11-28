package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	public int[] answer = {0, 0, 0};

	public void makeAnswer() {
		for (int i = 0; i < 3; i++) {
			int num = Randoms.pickNumberInRange(1, 9);

			if (checkReduplication(num, i)) {
				answer[i] = num;
			} else {
				i--;
			}
		}
	}

	public boolean checkReduplication(int num, int idx) {
		for (int i = 0; i < idx; i++) {
			if (answer[i] == num) {
				return false;
			}
		}
		return true;
	}

}
