package baseball;

public enum ErrorCode {
    INVALID_ESTIMATION_INPUT_LENGTH("3개의 숫자를 띄어쓰기 없이 입력해야 합니다."),
    INVALID_GAME_EXIT_DECISION("1과 2 중 하나를 선택해야 합니다."),
    CONTAINS_INVALID_CHARACTER("입력은 숫자로만 이루어져야 합니다");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
