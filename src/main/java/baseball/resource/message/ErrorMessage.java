package baseball.resource.message;

import baseball.resource.GameRule;

public class ErrorMessage {

    public static final String NOT_NUMBER_MESSAGE = "입력된 값이 숫자가 아닙니다.";
    public static final String NUMBER_NOT_IN_RANGE_MESSAGE = "범위 안의 숫자가 아닙니다.";
    public static final String NUMBERS_NOT_MATCH_DIGITS_MESSAGE = GameRule.NUMBERS_DIGITS + "자리의 숫자가 아닙니다.";
    public static final String NUMBERS_DUPLICATED_MESSAGE = "중복된 숫자가 있습니다.";
    public static final String NOT_PICKED_REFEREE_NUMBERS = "게임에 사용될 숫자가 준비되어 있지 않습니다.";

}
