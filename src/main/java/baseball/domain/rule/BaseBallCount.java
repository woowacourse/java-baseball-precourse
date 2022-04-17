package baseball.domain.rule;

public enum BaseBallCount {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    private final String name;

    BaseBallCount(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
