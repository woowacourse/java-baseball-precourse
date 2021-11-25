package baseball.domain;

import baseball.util.Converter;
import baseball.util.DupChecker;
import baseball.util.Validator;
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

	public Result offer(String input) {
		// TODO 숫자를 입력받는다.
		// input에 대한 유효성을 검사한다
		if(!Validator.isNumeric(input)){
			throw new IllegalArgumentException();
		}
		int[] playerNum = Converter.convertToIntArr(input);
		Validator.valid(playerNum);

		// 만약 input이 맞다면 정답과 비교한다
		return null;
	}

	public boolean printResult(Result result) {
		// 결과를 출력한다.
		return false;
	}
}
