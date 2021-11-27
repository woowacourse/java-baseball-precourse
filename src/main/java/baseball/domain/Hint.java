package baseball.domain;

public class Hint {
    private int balls;
    private int strikes;

    public Hint() {
        this.balls = 0;
        this.strikes = 0;
    }

    public void increaseBall() {
        this.balls++;
    }

    public void increaseStrike() {
        this.strikes++;
    }

}
