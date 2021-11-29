package baseball.resource.message;

import baseball.resource.rule.NumberDigit;

public class ErrorMessage {

    public static final String INPUT_NOT_INTEGER_MESSAGE = "입력된 값이 숫자가 아닙니다.";
    public static final String INPUT_OUT_OF_OPTIONS_MESSAGE = "입력된 값이 옵션에 속하지 않습니다.";

    public static final String INPUT_NUMBERS_NOT_MATCH_DIGITS_MESSAGE = NumberDigit.getCount() + "자리의 숫자가 아닙니다.";
    public static final String INPUT_NUMBERS_DUPLICATED_MESSAGE = "중복된 숫자가 있습니다.";

    public static final String NUMBER_OUT_OF_RANGE_MESSAGE = "범위 안의 숫자가 아닙니다.";

    public static final String NOT_PICKED_REFEREE_NUMBERS = "게임에 사용될 숫자가 준비되어 있지 않습니다.";

}
