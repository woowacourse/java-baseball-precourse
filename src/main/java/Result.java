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

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (strike > 0) {
            output.append(strike);
            output.append(" 스트라이크 ");
        }
        if (ball > 0) {
            output.append(ball);
            output.append("볼");
        }
        if (strike == 0 && ball == 0)  {
            output.append("낫싱");
        }
        return output.toString().trim();
    }
}