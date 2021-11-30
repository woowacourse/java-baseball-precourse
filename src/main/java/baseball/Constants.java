package baseball;

public class Constants {
	public static final int LOWER_BOUND = 1;
	public static final int UPPER_BOUND = 9;
	public static final int DIGIT_LENGTH = 3;
	public static final int RESTART = 1;
	public static final int END_GAME = 2;

	public static final String ENTER_THREE_DIGIT = "숫자를 입력하세요: ";
	public static final String ENTER_RESTART_FLAG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static final String RESULT_NOTHING = "낫싱";
	public static final String RESULT_STRIKE = "스트라이크";
	public static final String RESULT_BALL = "볼";
	public static final String RESULT_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static final String ERROR_RESTART_FLAG = "restart flag must be 1 or 2";
	public static final String ERROR_VALIDATE_LENGTH = "length of player input must be 3";
	public static final String ERROR_DUPLICATE_NUM = "player input must be different each other";
}
