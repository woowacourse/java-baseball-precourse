package baseball;

class Result {
    int strike;
    int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isStrikeOut() {
        return strike == 3;
    }

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) return "낫싱";
        if (ball == 0) return strike + "스트라이크";
        if (strike == 0) return ball + "볼";
        return ball + "볼 " + strike + "스트라이크";
    }
}
