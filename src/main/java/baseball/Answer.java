package baseball;

import utils.RandomUtils;

public class Answer {

	static final int MIN_NUM = 1; // 범위 내 최솟값
	static final int MAX_NUM = 9; // 범위 내 최댓값
	static final int NUM_LEN = 3; // 자리 수

	int[] answerNum = new int[NUM_LEN]; // 타깃 넘버를 담는 배열
	boolean[] checkNum = new boolean[MAX_NUM + 1]; // 중복 검사를 위한 배열

	// 랜덤값으로 타깃넘버를 만드는 함수
	public void makeAnswer() {
		int idx = 0;
		while (idx < NUM_LEN) {
			int num = RandomUtils.nextInt(MIN_NUM, MAX_NUM);
			if (checkNum[num])
				continue;

			answerNum[idx++] = num;
			checkNum[num] = true;
		}
	}
}
