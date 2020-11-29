package baseball.constant;

public final class Constants {
    /*
     * 시작과 게임 완료 시 출력하는 안내문
     */
    public static final String PLEASE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String PLEASE_INPUT_RETRY_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    /*
     * 비정상적 입력에 대한 경고문
     */
    public static final String PLEASE_INPUT_THREE_DIGIT_NUMBER = "3자리 숫자를 입력해주세요.";
    public static final String PLEASE_INPUT_NON_ZERO_NUMBER = "0이 포함되지 않은 3자리 숫자를 입력해주세요.";
    public static final String PLEASE_INPUT_ALL_DIFFERENT_NUMBER = "서로 다른 숫자 3자리로 입력해주세요.";
    public static final String PLEASE_INPUT_ONE_DIGIT_NUMBER = "1 또는 2를 입력해주세요.";

    /*
     * 정답과 사용자 입력 비교시 출력문
     */
    public static final String NOTHING = "낫싱";
    public static final String ALL_STRIKE = "3스트라이크" + "\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    /*
     * 입력값 검증 또는 구현 시 필요한 값
     */
    public static final String CONTAIN_ZERO = "0";
    public static final String RESTART = "1";
    public static final String EXIT = "2";

    public static final int VALUE_ZERO = 0;
    public static final int VALUE_ONE = 1;
    public static final int VALUE_NINE = 9;
    public static final int ANSWER_LENGTH = 3;
    public static final int INVALID_RETRY_NUMBER = -1;
    public static final int PLAY = 1;
}
