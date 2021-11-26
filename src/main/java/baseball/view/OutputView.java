package baseball.view;

import baseball.constant.BaseballConst;
import baseball.domain.Result;

public class OutputView {
	public static void printInputMessage() {
		System.out.print(BaseballConst.INPUT_INTRO);
	}

	public static void printResult(Result result) {
		if (isNothing(result)) {
			printNothingMessage();
			return;
		}

		StringBuilder sb = new StringBuilder();
		if (haveBall(result)) {
			addBallMessage(result, sb);
		}
		if (haveStrike(result)) {
			addStrikeMessage(result, sb);
		}

		printMessage(sb);
	}

	public static void printGameEnd() {
		System.out.println(BaseballConst.GAME_END);
	}

	public static void printRetryOrExit() {
		System.out.println(BaseballConst.RETRY_OR_EXIT);
	}

	private static void printMessage(StringBuilder sb) {
		System.out.println(sb);
	}

	private static void addStrikeMessage(Result result, StringBuilder sb) {
		sb.append(result.getStrikeCount());
		sb.append(BaseballConst.STRIKE);
	}

	private static void addBallMessage(Result result, StringBuilder sb) {
		sb.append(result.getBallCount());
		sb.append(BaseballConst.BALL + " ");
	}

	private static void printNothingMessage() {
		System.out.println(BaseballConst.NOTHING);
	}

	private static boolean haveStrike(Result result) {
		return result.getStrikeCount() > 0;
	}

	private static boolean haveBall(Result result) {
		return result.getBallCount() > 0;
	}

	private static boolean isNothing(Result result) {
		return result.getStrikeCount() == 0 && result.getBallCount() == 0;
	}
}
