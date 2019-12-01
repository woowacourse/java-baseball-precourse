public class HintResult implements ComparedResult {
    private int strike;
    private int ball;

    public HintResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public void printMessage() {
        System.out.println(strike + " 스트라이크 " + ball + " 볼");
    }

    @Override
    public boolean isGameRunning() {
        return true;
    }
}
