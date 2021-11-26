package baseball.view;

import baseball.constant.BaseballConst;
import baseball.domain.Result;

public class OutputView {
	public static void printInputMessage() {
		System.out.print(BaseballConst.INPUT_INTRO);
	}

	public static void printResult(Result result) {
		if (result.getStrikeCount() == 0 && result.getBallCount() == 0) {
			System.out.println(BaseballConst.NOTHING);
			return;
		}

		StringBuilder sb = new StringBuilder();

		if (result.getBallCount() > 0) {
			sb.append(result.getBallCount());
			sb.append(BaseballConst.BALL + " ");
		}
		if (result.getStrikeCount() > 0) {
			sb.append(result.getStrikeCount());
			sb.append(BaseballConst.STRIKE);
		}

		System.out.println(sb);
	}

	public static void printGameEnd() {
		System.out.println(BaseballConst.GAME_END);
	}

	public static void printRetryOrExit() {
		System.out.println(BaseballConst.RETRY_OR_EXIT);
	}
}
