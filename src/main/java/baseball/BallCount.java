package baseball;

public class BallCount {
    private int strike;
    private int ball;
    
    public BallCount() {
        this.strike = 0;
        this.ball = 0;
    }
    
    public void setBall(int ball) {
        this.ball = ball;
    }
    
    public void setStrike(int strike) {
        this.strike = strike;
    }
    
    public int getBall() {
        return this.ball;
    }
    
    public int getStrike() {
        return this.strike;
    }
    
    public void printCount() {
        if (this.ball > 0 && this.strike > 0) {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        } else if (this.ball > 0) {
            System.out.println(this.ball + "볼");
        } else if (this.strike > 0) {
            System.out.println(this.strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }
}
