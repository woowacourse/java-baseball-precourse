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
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    BINGO("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n"
        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String type;

    Message(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
