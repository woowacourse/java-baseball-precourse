package baseball.views;

import static java.lang.String.*;

import baseball.domain.GameResult;

public class GameOutput {

	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String BALL_MESSAGE = "%d볼 ";
	private static final String STRIKE_MESSAGE = "%d스트라이크";
	private static final String GAME_END_MESSAGE = "\n3개의 숫자를 모두 맞히셨습니다 ! 게임 종료";

	private GameOutput() {
	}

	public static void printHint(GameResult gameResult) {
		StringBuilder sb = new StringBuilder();
		if (gameResult.isNothing()) {
			sb.append(NOTHING_MESSAGE);
		}
		if (gameResult.hasBall()) {
			sb.append(format(BALL_MESSAGE, gameResult.countBall()));
		}
		if (gameResult.hasStrike()) {
			sb.append(format(STRIKE_MESSAGE, gameResult.countStrike()));
		}
		if (gameResult.isPlayerWin()) {
			sb.append(GAME_END_MESSAGE);
		}
		System.out.println(sb);
	}
}
