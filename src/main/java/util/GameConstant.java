package util;

/**
 * Game 진행에 사용될 상수값
 */
public class GameConstant {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBER_LENGTH = 3;
    public static final int NO_SAME_VALUE = -1;

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    public static final String REQUEST_INPUT = "숫자를 입력해주세요 : ";
    public static final String THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String ASK_RESTART_OR_STOP = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static final String INVALID_INPUT_ERROR = "입력값 오류입니다. 게임을 종료합니다.";
    public static final String FINISH_GAME = "게임을 종료합니다.";
}
