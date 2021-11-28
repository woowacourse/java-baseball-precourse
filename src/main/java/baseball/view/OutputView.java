package baseball.view;

import baseball.domain.GameBoard;

public class OutputView {
	private static final String BALL_COUNT_MESSAGE = "%d볼 ";
	private static final String STRIKE_COUNT_MESSAGE = "%d스트라이크";
	private static final String NOTHING_COUNT_MESSAGE = "낫싱";
	private static final String GAME_RESULT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void showHintMessage(GameBoard gameBoard) {
		if (gameBoard.getBallCount() > 0) {
			System.out.printf(BALL_COUNT_MESSAGE, gameBoard.getBallCount());
		}
		if (gameBoard.getStrikeCount() > 0) {
			System.out.printf(STRIKE_COUNT_MESSAGE, gameBoard.getStrikeCount());
		}
		if (gameBoard.getBallCount() == 0 && gameBoard.getStrikeCount() == 0) {
			System.out.print(NOTHING_COUNT_MESSAGE);
		}
		System.out.println();
	}

	public static void showGameResultMessage() {
		System.out.println(GAME_RESULT_MESSAGE);
	}
}