package baseball.resource;

public class GameMessage {
    // 출력 메세지
    public static final String REQUEST_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String REQUEST_PLAY_OR_STOP_MESSAGE =
            String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            GameRule.NUMBER_GAME_PLAY, GameRule.NUMBER_GAME_STOP);

    // 에러 메세지
    public static final String NOT_NUMBER_MESSAGE = "입력된 값이 숫자가 아닙니다.";
    public static final String NUMBER_NOT_IN_RANGE_MESSAGE = "범위 안의 숫자가 아닙니다.";
    public static final String NUMBERS_NOT_MATCH_DIGITS_MESSAGE = GameRule.NUMBERS_DIGITS + "자리의 숫자가 아닙니다.";
    public static final String NUMBERS_DUPLICATED_MESSAGE = "중복된 숫자가 있습니다.";
}
