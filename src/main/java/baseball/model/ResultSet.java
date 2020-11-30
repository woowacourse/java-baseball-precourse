package baseball.model;

public class ResultSet {
    private int numberOfStrikes;
    private int numberOfBalls;

    public ResultSet(int givenNumberOfStrikes, int givenNumberOfBalls) {
        this.numberOfStrikes = givenNumberOfStrikes;
        this.numberOfBalls = givenNumberOfBalls;
    }

    public int numberOfStrikes() {
        return numberOfStrikes;
    }

    public int numberOfBalls() {
        return numberOfBalls;
    }
}
