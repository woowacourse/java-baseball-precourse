package baseball.domain;

public class User extends Participant {
    private int ballNumber;
    private int strikeNumber;

    public User() {
        super();
        this.ballNumber = 0;
        this.strikeNumber = 0;
    }

    public void setBallNumber(int targetBallNumber) {
        ballNumber = targetBallNumber;
    }

    public void setStrikeNumber(int targetStrikeNumber) {
        strikeNumber = targetStrikeNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }
}
