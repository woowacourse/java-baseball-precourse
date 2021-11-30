package view;

import domain.CompareResult;

public class OutputView {
	private static final String INPUT_REQUEST = "숫자를 입력해주세요 : ";
	private static final String RESTART_OR_END_REQUEST = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";

	public static void printInputRequest() {
		System.out.print(OutputView.INPUT_REQUEST);
	}

	public static void printRestartOrEnd() {
		System.out.println(OutputView.RESTART_OR_END_REQUEST);
	}

	public static void printRoundResult(CompareResult compareResult) {
		int ballCount = compareResult.getBall();
		int strikeCount = compareResult.getStrike();
		StringBuilder resultMessage = new StringBuilder();

		if (ballCount + strikeCount == 0) {
			resultMessage.append(NOTHING);
		}

		if (ballCount > 0) {
			resultMessage.append(ballCount + BALL + " ");
		}

		if (strikeCount > 0) {
			resultMessage.append(strikeCount + STRIKE);
		}

		System.out.println(resultMessage);

		if (strikeCount == 3) {
			System.out.println(END_MESSAGE);
		}
	}
}
