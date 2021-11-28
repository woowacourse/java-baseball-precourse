package baseball.error;

public enum ErrorMessage {

    INVALID_SIZE("입력값의 크기는 3 이하 입니다."),
    INVALID_NUMBER("입력값은 숫자 여야 합니다."),
    DUPLICATE_NUMBER("입력값은 중복될 수 없습니다."),
    INVALID_NUMBER_RANGE("각 자릿수는 1 ~ 9 사이 입니다."),
    INVALID_INPUT_COMMAND("커맨드는 1과 2만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}