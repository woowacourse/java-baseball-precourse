package baseball;

public class Constant {
	public static final int BALL_MIN_VALUE = 1;
	public static final int BALL_MAX_VALUE = 9;
	public static final int BALL_LIST_SIZE = 3;
	public static final int BALL_FIRST_POSITION = 1;
	public static final int RESTART_BUTTON = 1;
	public static final int EXIT_BUTTON = 2;
	public static final String INVALID_NUMBER_VALUE_MESSAGE =
		"숫자는 " + BALL_MIN_VALUE + "부터 " + BALL_MAX_VALUE + "이하의 숫자만 입력할 수 있습니다.";
	public static final String INVALID_NUMBER_COUNT_MESSAGE = BALL_LIST_SIZE + "자리의 숫자를 입력해야 합니다.";
	public static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "숫자가 중복되게 입력할 수 없습니다.";
	public static final String NUMBER_INPUT_ALARM_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String GAME_WIN_MESSAGE = BALL_LIST_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String GAME_RESTART_OR_EXIT_MESSAGE =
		"게임을 새로 시작하려면 " + RESTART_BUTTON + ", 종료하려면 " + EXIT_BUTTON + "를 입력하세요.";
	public static final String OUTPUT_STRIKE_MESSAGE = "스트라이크";
	public static final String OUTPUT_BALL_MESSAGE = "볼";
	public static final String OUTPUT_NOTHING_MESSAGE = "낫싱";
}