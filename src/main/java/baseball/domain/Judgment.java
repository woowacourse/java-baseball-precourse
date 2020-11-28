package baseball.domain;

public enum Judgment {
    STRIKE("스트라이크"),
    BALL("볼 "),
    NOTHING("낫싱");

    private final String message;

    Judgment(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
