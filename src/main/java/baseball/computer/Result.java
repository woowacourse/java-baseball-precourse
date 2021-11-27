package baseball.computer;

import static baseball.util.ConstantUtil.*;

import java.util.List;
import java.util.Objects;

// 응답과 정답을 통해 결과를 도출하는 클래스
public class Result {
	private int strike;
	private int ball;

	public boolean matchAnswer(List<Integer> answer, List<Integer> gameReply) {
		resetCount();

		for (int idx = 0; idx < ANSWER_SIZE; idx++) {
			if (Objects.equals(answer.get(idx), gameReply.get(idx))) {
				addStrike();
				continue;
			}
			if (answer.contains(gameReply.get(idx))) {
				addBall();
			}
		}
		return strike == ANSWER_SIZE;
	}

	private void resetCount() {
		this.strike = 0;
		this.ball = 0;
	}

	private void addStrike() {
		this.strike++;
	}

	private void addBall() {
		this.ball++;
	}

	public void printResult() {
		if (ball == 0 && strike == 0) {
			System.out.println("낫싱");
			return;
		}
		if (ball != 0) {
			System.out.print(ball + "볼 ");
		}
		if (strike == 0) {
			System.out.println();
			return;
		}
		System.out.println(strike + "스트라이크");
		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}

}
