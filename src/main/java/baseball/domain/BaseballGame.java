package baseball.domain;

import baseball.util.Converter;
import baseball.util.DupChecker;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
	private int[] answer;
	private Referee referee;

	public BaseballGame() {
		answer = null;
		referee = null;
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
		// 레프리 생성 : answer 값을 저장해둔다.
		referee = new Referee(answer);
	}

	public int[] validCheck(String input) {
		// input에 대한 유효성을 검사한다
		Validator.checkNumeric(input);
		int[] playerNum = Converter.convertToIntArr(input);
		Validator.valid(playerNum);
		return playerNum;
	}

	public Result offer(int[] playerNum) {
		return referee.check(playerNum);
	}
}
