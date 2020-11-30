package baseball;

public final class Constants {

    // 숫자 야구 게임의 최대 투구 횟수를 저장할 변수
    public static final int GAME_MAX_BASEBALL_PITCH = 3;
    // 숫자 야구 게임의 최소 숫자를 저장햘 변수
    public static final int GAME_MIN_BASEBALL_NUMBER = 1;
    // 숫자 야구 게임의 최대 숫자를 저장할 변수
    public static final int GAME_MAX_BASEBALL_NUMBER = 9;

    // 사용자가 프로그램 종료를 원하지 않을 경우 입력할 것으로 예상될 문자열
    public static final String STRING_USER_NOT_EXIT = "1";
    // 사용자가 프로그램 종료를 원할 경우 입력할 것으로 예상될 문자열
    public static final String STRING_USER_EXIT = "2";

    // 사용자에게 입력을 요구할 때 콘솔에 출력할 문자열
    public static final String MESSAGE_GAME_INPUT = "숫자를 입력해 주세요 : ";
    // 게임이 종료되었음을 알릴 때 콘솔에 출력할 문자열
    public static final String MESSAGE_GAME_FINISHED =
        GAME_MAX_BASEBALL_PITCH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    // 게임의 재시작 여부를 사용자에게 물을 때 콘솔에 출력할 문자열
    public static final String MESSAGE_GAME_REPLAY =
        "게임을 새로 시작하려면 " + STRING_USER_NOT_EXIT + ", 종료하려면 " + STRING_USER_EXIT + "를 입력하세요.";
    // 스트라이크와 볼이 모두 존재하지 않을 경우 콘솔에 출력할 문자열
    public static final String MESSAGE_RESULT_NOTHING = "낫싱";
    // 볼의 갯수 뒤에 붙여 콘솔에 출력할 문자열
    public static final String MESSAGE_RESULT_BALL = "볼";
    // 스트라이크의 갯수 뒤에 붙여 콘솔에 출력할 문자열
    public static final String MESSAGE_RESULT_STRIKE = "스트라이크";

    private Constants() {
    }
}
