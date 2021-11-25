package baseball.view;

import baseball.domain.Result;

public class OutputView {
	private static final String INPUT_INTRO = "숫자를 입력해주세요 : ";
	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";
	private static final String GAME_END = "3개의 숫자를 모두 맞추셨습니다! 게임 종료";

	public static void printInputMessage() {
		System.out.print(INPUT_INTRO);
	}

	public static void printResult(Result result) {
		if (result.getStrikeCount() == 0 && result.getBallCount() == 0) {
			System.out.println(NOTHING);
			return;
		}

		StringBuilder sb = new StringBuilder();

		if (result.getBallCount() > 0) {
			sb.append(result.getBallCount());
			sb.append(BALL + " ");
		}
		if (result.getStrikeCount() > 0) {
			sb.append(result.getStrikeCount());
			sb.append(STRIKE);
		}

		System.out.println(sb.toString());
	}

	public static void printDone() {
		System.out.println(GAME_END);
	}
}
