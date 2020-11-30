package baseball;

public enum BallType {
    BALL("볼"),
    STRIKE("스트라이크");

    private String name;

    BallType(String name) {
        this.name = name;
    }

    public String getNameWith(int count) {
        return count + name;
    }
}
