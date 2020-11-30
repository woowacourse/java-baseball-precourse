package baseball;

import static baseball.Constants.GAME_MAX_BASEBALL_PITCH;

public enum ErrorMessages {

    ARRAY_INVALID_LENGTH("숫자는 " + GAME_MAX_BASEBALL_PITCH + "개만 입력해야 합니다"),
    ARRAY_ITEM_DUPLICATED("배열 내에 중복된 숫자가 있습니다"),
    ARRAY_ITEM_OUT_OF_RANGE("배열 내에 범위를 벗어난 숫자가 존재합니다"),
    INPUT_INVALID_STRING("잘못된 입력 형식입니다");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
