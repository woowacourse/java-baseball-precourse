package baseball.domain;

public class Participant {
    protected int[] ballBunch;

    Participant() {

    }

    public void setBallBunch(int[] ballSetting) {
        ballBunch = ballSetting;
    }

    public int[] getBallBunch() {
        return ballBunch;
    }
}
