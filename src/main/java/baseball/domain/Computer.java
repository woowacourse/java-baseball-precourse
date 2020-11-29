package baseball.domain;

public class Computer extends Participant {
    public Computer() {
        super();
    }

    @Override
    public int[] getBallBunch() {
        return ballBunch;
    }
}
