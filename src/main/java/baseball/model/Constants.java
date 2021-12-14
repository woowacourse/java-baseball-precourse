package baseball.model;

public class Constants {
    // 메시지 관련 메시지
    public static final String GAME_START_MSG = "게임을 시작하겠습니다.";
    public static final String GAME_END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_RESTART_OR_STOP_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_EXIT_MSG = "게임을 종료하겠습니다. 감사합니다.";

    // 입출력 관련 메시지
    public static final String INPUT_NUMBER_MSG = "숫자를 입력해주세요 : ";
    public static final String INPUT_ERROR_MSG = "잘못된 입력입니다.";

    // 야구게임 관련 메시지
    public static final int ANSWER_LENGTH = 3;
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String BLANK = " ";

    // 정답 생성 관련 상수
    public static final int STARTINCLUSIVE = 1;
    public static final int ENDINCLUSIVE = 9;

    // continueOrExit()
    public static final String CONTINUE = "1";
    public static final String EXIT = "2";

    public static final String INPUT_VALIDATE_PATTERN = "^[1-9]{3}$";
}