package baseball.view;

import baseball.domain.RandomNumber;

public class OutputView {
	private static final String IS_BALL = "볼 ";
	private static final String IS_STRIKE = "스트라이크";
	private static final String IS_NOTHING = "낫싱";
	private static final String THREE_STRIKE_GAME_OVER = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void printBallAndStrikeCount(int ball, int strike) {
		String hint = "";
		if (ball == 0 && strike == 0) {
			System.out.println(IS_NOTHING);
			return;
		}
		if (ball != 0) {
			hint += (ball + IS_BALL);
		}
		if (strike != 0) {
			hint += (strike + IS_STRIKE);
		}
		if (strike == RandomNumber.PICK_NUMBER) {
			hint += THREE_STRIKE_GAME_OVER;
		}
		System.out.println(hint);
	}

}
