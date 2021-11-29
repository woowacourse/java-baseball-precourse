package baseball.utils;

public class Constant {
	public static final String ON_GOING = "1";
	public static final String STOP = "2";

	public static final int ZERO = 0;
	public static final int LIMITED_LENGTH = 3;
	public static final int LIMITED_RESTART_INPUT_LENGTH = 1;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;
	public static final String EMPTY_STRING = " ";
	public static final String NO_STRING = "";

	public static final String GAME_EXIT_INSTRUCTION = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
		+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String INVALID_INPUT_DUPLICATED_MESSAGE = "같은 수를 2번이상 입력하였습니다.";
	public static final String INVALID_INPUT_FORMAT_MESSAGE = "숫자를 입력하세요.";
	public static final String INVALID_INPUT_LENGTH_MESSAGE = "숫자 3개를 입력해주세요.";
	public static final String INVALID_INPUT_RANGE_MESSAGE = "1~9사이의 값을 입력해주세요.";

	public static final String RESULT_NOTHING = "낫싱";
	public static final String RESULT_BALL = "볼";
	public static final String RESULT_STRIKE = "스트라이크";
	public static final String RESULT_THREE_STRIKE = "3스트라이크";

	public static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String REQUEST_RESTART_INPUT_LENGTH_MESSAGE = "1개만 입력해주세요";
	public static final String REQUEST_RESTART_INPUT_RANGE_MESSAGE = "1 혹은 2를 입력해주세요";

}
