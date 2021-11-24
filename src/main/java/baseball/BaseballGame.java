package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
	private int[] answer;

	public BaseballGame() {
		answer = null;
	}

	public void init() {
		// 초기값 세팅 : 중복되지 않는 1~9로 구성된 세 자리 수 생성
		answer = new int[3];
		int cnt = 0;
		DupChecker dupChecker = new DupChecker();

		while (cnt < 3) {
			int nowNum = Randoms.pickNumberInRange(1, 9);
			if (dupChecker.check(nowNum)) {
				answer[cnt++] = nowNum;
			}
		}
	}

	public int[] getAnswer() {
		return answer;
	}

	public Result offer(int num) {
		// TODO 숫자를 입력받는다.
		// BaseballGame이 가진 수와 num을 비교하여 Result를 생성하여 리턴한다.
		return null;
	}
}
