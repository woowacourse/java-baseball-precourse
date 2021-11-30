package baseball;

public class StringUtil {
    public static final int START_BUTTON = 1;
    public static final int END_BUTTON = 2;
    public static final int NUMBER_OF_DIGITS_OF_START_END_BUTTON = 1;

    public static final int NUMBER_OF_DIGITS_OF_GAME_NUMBER = 3;
    public static final int MIN_GAME_NUMBER = 1;
    public static final int MAX_GAME_NUMBER = 9;
    public static final int ASCII_VALUE_OF_MIN_GAME_NUMBER = MIN_GAME_NUMBER + '0';
    public static final int ASCII_VALUE_OF_MAX_GAME_NUMBER = MAX_GAME_NUMBER + '0';

    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NUMBER_REQUEST_MESSAGE = "숫자를 입력해 주세요 : ";
    public static final String START_END_BUTTON_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String STRIKE_TO_PRINT = "스트라이크";
    public static final String BALL_TO_PRINT = "볼";
    public static final String NOTHING = "낫싱";

    private StringUtil() {
    }
}
