package baseball.view;

import baseball.controller.BaseballSet;
import baseball.model.Constant;

public class OutputView {
	private final int BALL_COUNT;
	private final int STRIKE_COUNT;

	public OutputView(BaseballSet set) {
		this.BALL_COUNT = set.BALL_COUNT;
		this.STRIKE_COUNT = set.STRIKE_COUNT;
	}

	public static void printGameClear() {
		System.out.println(Constant.NUMS_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void printGameResult() {
		printOnlyBall();
		printOnlyStrike();
		printBallAndStrike();
		printNoting();
	}

	private void printOnlyBall() {
		if (BALL_COUNT != 0 && STRIKE_COUNT == 0) {
			System.out.println(BALL_COUNT + "볼");
		}
	}

	private void printOnlyStrike() {
		if (BALL_COUNT == 0 && STRIKE_COUNT != 0) {
			System.out.println(STRIKE_COUNT + "스트라이크");
		}
	}

	private void printBallAndStrike() {
		if (BALL_COUNT != 0 && STRIKE_COUNT != 0) {
			System.out.println(BALL_COUNT + "볼 " + STRIKE_COUNT + "스트라이크");
		}
	}

	private void printNoting() {
		if (BALL_COUNT == 0 && STRIKE_COUNT == 0) {
			System.out.println("낫싱");
		}
	}
}
