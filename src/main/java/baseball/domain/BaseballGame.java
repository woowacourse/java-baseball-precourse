package baseball.domain;

import baseball.constant.BaseballConst;
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
		chooseRandomAnswer();
		// 레프리 생성 : answer 값을 저장해둔다.
		refereeInit();
	}

	public int[] checkValid(String input) {
		Validator.checkNumeric(input);
		int[] playerNum = Converter.convertToIntArr(input);
		Validator.valid(playerNum);
		return playerNum;
	}

	public Result offer(int[] playerNum) {
		return referee.check(playerNum);
	}

	private void chooseRandomAnswer() {
		answer = new int[3];
		int cnt = 0;
		DupChecker dupChecker = new DupChecker();

		while (cnt < 3) {
			int nowNum = Randoms.pickNumberInRange(BaseballConst.MIN_NUM, BaseballConst.MAX_NUM);
			if (dupChecker.check(nowNum)) {
				answer[cnt++] = nowNum;
			}
		}
	}

	private void refereeInit() {
		referee = new Referee(answer);
	}
}
