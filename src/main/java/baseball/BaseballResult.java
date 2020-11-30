package baseball;

public class BaseballResult {

    private final int countOfStrike;
    private final int countOfBall;

    public BaseballResult(int countOfStrike, int countOfBall) {
        this.countOfStrike = countOfStrike;
        this.countOfBall = countOfBall;
    }

    public int getStrike() {
        return countOfStrike;
    }

    public int getBall() {
        return countOfBall;
    }
}
