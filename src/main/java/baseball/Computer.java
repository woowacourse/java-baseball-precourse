package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private final int MIN_NUM = 1;
	private final int MAX_NUM = 9;
	private final int ANSWER_SIZE;
	private boolean[] flag;
	public int[] answer;

	public Computer(int answerSize) {
		ANSWER_SIZE = answerSize;
		answer = new int[answerSize];
		flag = new boolean[MAX_NUM + 1];
		for (int i = 0; i < answerSize; i++) {
			answer[i] = 0;
		}
		for (int i = 0; i < MAX_NUM + 1; i++) {
			flag[i] = false;
		}
	}

	public void makeAnswer() {
		for (int i = 0; i < ANSWER_SIZE; i++) {
			int num = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);

			if (checkReduplication(num)) {
				answer[i] = num;
			} else {
				i--;
			}

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
