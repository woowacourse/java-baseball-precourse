public class GameResult {
    protected int strike;
    protected int ball;

    /**
     * GameResult 생성자
     * 생성시 무조건 strike 와 ball 은 0 으로 초기화 된다.
     */
    public GameResult() {
        this.strike = 0;
        this.ball = 0;
    }

    protected void oneMoreStrike() {
        this.strike += 1;
    }

    protected void oneMoreBall() {
        this.ball += 1;
    }

    protected void initStrikeAndBall() {
        this.strike = this.ball = 0;
    }

    protected boolean isThreeStrike() {
        return this.strike == 3;
    }

    public void printStrikeAndBall() {
        if (this.strike == 0 && this.ball == 0) {
            System.out.println("포볼");
        }
        else if (this.strike == 0) {
            System.out.printf("%d 볼\n", this.ball);
        }
        else if (this.ball == 0) {
            System.out.printf("%d 스트라이크\n", this.strike);
        }
        else {
            System.out.printf("%d 스트라이크 %d 볼\n", this.strike, this.ball);
        }
    }
}
