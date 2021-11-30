package baseball;

public enum PrintValue {

    // starting
    START("숫자를 입력해주세요 : "),

    // playing
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),

    // finish
    FINISH("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String content;

    PrintValue(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
