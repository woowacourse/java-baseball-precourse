package baseball;

import static java.lang.String.*;

public class GameOutput {

	private GameOutput() {
	}

	public static void printHint(GameResult gameResult) {
		StringBuilder sb = new StringBuilder();
		if (gameResult.isNothing()) {
			sb.append("낫싱");
		}
		if (gameResult.hasBall()) {
			sb.append(format("%d볼 ", gameResult.countBall()));
		}
		if (gameResult.hasStrike()) {
			sb.append(format("%d스트라이크", gameResult.countStrike()));
		}
		if (gameResult.isPlayerWin()) {
			sb.append("\n3개의 숫자를 모두 맞히셨습니다 ! 게임 종료");
		}
		System.out.println(sb);
	}
}
