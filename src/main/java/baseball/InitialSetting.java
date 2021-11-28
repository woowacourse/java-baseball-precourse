package baseball;

public class InitialSetting {
    public static final String NEW_GAME_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NEW_GAME_INPUT_ERR_MSG = "잘못된 입력입니다. 1 또는 2로 입력하세요. 게임 종료";
    public static final String INPUT = "숫자를 입력해주세요: ";
    public static final String ERR_MSG = "올바르지 않은 형식의 숫자를 입력하셨습니다. 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력하세요. 게임 종료";
    public static final String ALL_STRIKE_MSG = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String STRIKE_MSG = "스트라이크";
    public static final String BALL_MSG = "볼";
    public static final String NOTHING_MSG = "낫싱";

    public static final int NUM_SIZE = 3;
    public static final int MIN_NUM_VALUE = 1;
    public static final int MAX_NUM_VALUE = 9;
    public static final int MAX_STRIKES = 3;
    public static final int NONE = 0;
    public static final int RESTART_GAME = 1;
    public static final int END_GAME = 2;
}
