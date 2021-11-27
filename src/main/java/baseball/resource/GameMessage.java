package baseball.resource;

public class GameMessage {
    // 게임 데이터
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    // 출력 메세지
    public static final String REQUEST_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String REQUEST_PLAY_OR_STOP_MESSAGE = String.format(
            "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", GameRule.NUMBER_GAME_PLAY, GameRule.NUMBER_GAME_STOP);
    public static final String GAME_CLEAR_MESSAGE = GameRule.NUMBERS_DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    // 에러 메세지
    public static final String NOT_NUMBER_MESSAGE = "입력된 값이 숫자가 아닙니다.";
    public static final String NUMBER_NOT_IN_RANGE_MESSAGE = "범위 안의 숫자가 아닙니다.";
    public static final String NUMBERS_NOT_MATCH_DIGITS_MESSAGE = GameRule.NUMBERS_DIGITS + "자리의 숫자가 아닙니다.";
    public static final String NUMBERS_DUPLICATED_MESSAGE = "중복된 숫자가 있습니다.";
    public static final String NOT_PICKED_REFEREE_NUMBERS = "게임에 사용될 숫자가 준비되어 있지 않습니다.";
}
