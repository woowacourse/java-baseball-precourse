package baseball.domain;

public class Participant {
    protected int[] ballBunch;

    public Participant() {
        super();
    }

    public void setBallBunch(int[] ballSetting) {
        ballBunch = ballSetting;
    }

    public int[] getBallBunch() {
        return ballBunch;
    }
}
