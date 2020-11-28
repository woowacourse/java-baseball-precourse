package baseball.type;

public enum HintType {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String hint;

    HintType(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }
}
