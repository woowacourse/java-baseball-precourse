public class Result {
    private static final int NUMBER_COUNT = 3;

    private int strike;
    private int ball;

    public static Result of(int strike, int ball) {
        return new Result(strike, ball);
    }

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean allMatch() {
        return strike == NUMBER_COUNT;
    }
}