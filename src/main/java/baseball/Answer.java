package baseball;

import utils.RandomUtils;

public class Answer {
	int[] answerNum = new int[Constant.NUM_LEN]; // 타깃 넘버를 담는 배열
	boolean[] checkNum = new boolean[Constant.MAX_NUM + 1]; // 중복 검사를 위한 배열

	// 랜덤값으로 타깃넘버를 만드는 함수
	public void makeAnswer() {
		int idx = 0;
		while (idx < Constant.NUM_LEN) {
			int num = RandomUtils.nextInt(Constant.MIN_NUM, Constant.MAX_NUM);
			if (checkNum[num]) continue;

			answerNum[idx++] = num;
			checkNum[num] = true;
		}
	}
}
