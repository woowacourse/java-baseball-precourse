package baseball;

import static java.lang.String.*;

public class GameOutput {

	private GameOutput() {
	}

	public static void printHint(Hint hint) {
		StringBuilder sb = new StringBuilder();
		if (hint.isNothing()) {
			sb.append("낫싱");
		}
		if (hint.hasBall()) {
			sb.append(format("%d볼 ", hint.getBallCount()));
		}
		if (hint.hasStrike()) {
			sb.append(format("%d스트라이크", hint.getStrikeCount()));
		}
		if (hint.isPlayerWin()) {
			sb.append("\n3개의 숫자를 모두 맞히셨습니다 ! 게임 종료");
		}
		System.out.println(sb);
	}
}
