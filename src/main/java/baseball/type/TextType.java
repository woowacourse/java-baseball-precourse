package baseball.type;

public enum TextType {
    START("숫자를 입력해주세요 : "),
    ANSWER("개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_FINISH("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INVALID_INPUT("1 또는 2만 입력해주세요."),
    INVALID_LENGTH("3자리보다 짧은 길이의 숫자 또는 긴 길이의 숫자는 입력될 수 없습니다."),
    INVALID_BOUNDARY("문자 또는 0은 입력될 수 없습니다."),
    INVALID_NUMBER("동일한 숫자는 입력될 수 없습니다.");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
