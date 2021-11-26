package baseball;

import java.util.List;
import java.util.Objects;

public class Result {
	int strike;
	int ball;

	public void matchAnswer(List<Integer> answer, List<Integer> gameReply) {
		strike = 0;
		ball = 0;

		for (int idx = 0; idx < 3; idx++) {
			if (Objects.equals(answer.get(idx), gameReply.get(idx))) {
				strike += 1;
				continue;
			}
			if (answer.contains(gameReply.get(idx))) {
				ball += 1;
			}
		}
	}

	public void printResult() {
		if (ball == 0 && strike == 0) {
			System.out.println("낫싱");
			return;
		}
		if (ball != 0) {
			System.out.print(ball + "볼 ");
		}
		System.out.print(strike + "스트라이크");
		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}
}
