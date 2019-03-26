public class GameResult {
    private static int ZERO = 0;
    private static int ONE = 1;
    private static int STRIKETHREE = 3;

    protected int strike;
    protected int ball;

    /**
     * GameResult 생성자
     * 생성시 무조건 strike 와 ball 은 0 으로 초기화 된다.
     */
    protected GameResult() {
        this.strike = ZERO;
        this.ball = ZERO;
    }

    /**
     * Strike 가 있을 때 GameResult 인스턴스의 strike 를 1 증가시는 메서드
     */
    protected void oneMoreStrike() {
        this.strike += ONE;
    }

    /**
     * Ball 이 있을 때 GameResult 인스턴스의 ball 을 1 증가시키는 메서드
     */
    protected void oneMoreBall() {
        this.ball += ONE;
    }

    /**
     * GameResult 인스턴스를 초기상태로 되돌리기 위한 메서드
     */
    protected void initGameResult() {
        this.strike = this.ball = ZERO;
    }

    /**
     * GameResult 인스턴스의 strike 가 3이면 게임이 끝나므로 이를 검사하는 메서드
     * @return strike 가 3일때 true
     */
    protected boolean isEnd() {
        return this.strike == STRIKETHREE;
    }

    /**
     * this.strike 와 this.ball 의 값에 따라 결과를 콘솔에 출력하는 메서드
     */
    protected void print() {
        if (this.strike == ZERO && this.ball == ZERO) {
            System.out.println("포볼");
        }
        else if (this.strike == ZERO) {
            System.out.printf("%d 볼\n", this.ball);
        }
        else if (this.ball == ZERO) {
            System.out.printf("%d 스트라이크\n", this.strike);
            printSuccess();
        }
        else {
            System.out.printf("%d 스트라이크 %d 볼\n", this.strike, this.ball);
        }
    }

    private void printSuccess() {
        if (this.strike == STRIKETHREE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
