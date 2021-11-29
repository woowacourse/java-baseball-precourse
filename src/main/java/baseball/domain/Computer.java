package baseball.domain;

public class Computer {

    private GameBalls gameBalls;

    public Computer() {
        this.gameBalls = new GameBalls();
    }

    @Override
    public String toString() {
        return "Computer{" +
            "gameBalls=" + gameBalls +
            '}';
    }
}
