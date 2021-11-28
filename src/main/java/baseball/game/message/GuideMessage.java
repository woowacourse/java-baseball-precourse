package baseball.game.message;

public class GuideMessage {

	public static final String ENTER_NUM_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String NOTHING_MESSAGE = "낫싱";
	public static final String ERR_NOTHING_METHOD_PARAM = "낫싱 출력에 잘못된 인수가 전달되었습니다";
	public static final String BALL_MESSAGE = "볼";
	public static final String ERR_BALL_ONLY_METHOD_PARAM = "볼만 출력에 잘못된 인수가 전달되었습니다";
	public static final String STRIKE_MESSAGE = "스트라이크";
	public static final String ERR_STRIKE_ONLY_METHOD_PARAM = "스트라이크만 출력에 잘못된 인수가 전달되었습니다";
	public static final String ERR_BALL_STRIKE_METHOD_PARAM = "볼과 스트라이크 출력에 잘못된 인수가 전달되었습니다";
	public static final String WIN_GAME_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String ERR_CORRECT_NUMBER_PARAM = "정답 메세지 출력에 잘못된 인수가 전달되었습니다";

	public static String wrongNumberMessage(int ball, int strike) {
		if (ball == 0 && strike == 0) {
			return nothingMessage(ball, strike);
		} else if (strike == 0) {
			return ballOnlyMessage(ball, strike);
		} else if (ball == 0) {
			return strikeOnlyMessage(ball, strike);
		} else {
			return ballAndStrikeMessage(ball, strike);
		}
	}

	public static String nothingMessage(int ball, int strike) {
		if (ball == 0 && strike == 0) {
			return NOTHING_MESSAGE;
		} else {
			throw new IllegalArgumentException(ERR_NOTHING_METHOD_PARAM);
		}
	}

	public static String ballOnlyMessage(int ball, int strike) {
		if (strike == 0 && (ball == 1 || ball == 2 || ball == 3)) {
			return ball + BALL_MESSAGE;
		} else {
			throw new IllegalArgumentException(ERR_BALL_ONLY_METHOD_PARAM);
		}
	}

	public static String strikeOnlyMessage(int ball, int strike) {
		if (ball == 0 && (strike == 1 || strike == 2)) {
			return strike + STRIKE_MESSAGE;
		} else {
			throw new IllegalArgumentException(ERR_STRIKE_ONLY_METHOD_PARAM);
		}
	}

	public static String ballAndStrikeMessage(int ball, int strike) {
		if (ball == 1 && strike == 1 || ball == 2 && strike == 1) {
			return ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE;
		} else {
			throw new IllegalArgumentException(ERR_BALL_STRIKE_METHOD_PARAM);
		}
	}

	public static String correctNumberMessage(int ball, int strike) {
		if (ball == 0 && strike == 3) {
			return WIN_GAME_MESSAGE;
		} else {
			throw new IllegalArgumentException(ERR_CORRECT_NUMBER_PARAM);
		}
	}
}
