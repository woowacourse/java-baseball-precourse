package util;

public class GameConstant {
    // 상수
    public static final String RESTART = "1";
    public static final String STOP = "2";

    public static final int NUMBER_LENGTH = 3;
    public static final int MAX_RANGE = 9;
    public static final int MIN_RANGE = 1;

    // 정규 표현식
    public static final String INPUT_VALUE_REGEX = "^[1-9]{3}$";

    // 게임 진행 메세지
    public static final String INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String ASK_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    // 예외 케이스 메세지
    public static final String NOT_THREE_DIGIT_INTEGER_MESSAGE = "세 자리 정수를 입력하세요.";
    public static final String NOT_RELATED_ABOUT_RESTART_MESSAGE = "1 또는 2 이외의 값을 입력하셨습니다.";

    public static final String THREE_STRIKE_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NOTHING_MESSAGE = "낫싱";

    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크";

}
