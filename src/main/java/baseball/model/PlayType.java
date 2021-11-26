package baseball.model;

public enum PlayType {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    private final String name;

    PlayType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
