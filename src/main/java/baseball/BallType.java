package baseball;

public enum BallType {
    BALL("볼"),
    STRIKE("스트라이크");

    private String name;

    BallType(String name) {
        this.name = name;
    }

    public void printNameWith(int count) {
        System.out.print(count + name + " ");
    }
}
