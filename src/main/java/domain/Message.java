package domain;

/**
 * @author yhh1056
 * @since 2020/11/29
 */
public enum Message {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    BLANK(" "),
    INPUT_NUMBER("숫자를 입력해주세요 : ");

    private String type;

    Message(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
