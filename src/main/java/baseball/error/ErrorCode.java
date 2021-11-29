package baseball.error;

public enum ErrorCode {
    FOUND_NOT_DIGIT("숫자 외 다른 문자가 입력되었습니다."),
    NOT_IN_RANGE("입력받은 수는 3자리 수가 아닙니다."),
    IS_DUPLICATE("입력받은 수에는 중복된 수가 존재합니다."),
    HAS_ZERO("입력받은 수에 0이 존재합니다.");

    private final String content;

    ErrorCode(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
}
