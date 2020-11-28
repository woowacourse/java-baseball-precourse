package baseball;

public class Result {

    public int strike;
    public int ball;

    public void init() {
        strike = 0;
        ball = 0;
    }


    public void printHint() {
        printNothing();
        printBall();
        printStrike();
        System.out.println();
    }

    private void printNothing() {
        if (strike == 0 && ball == 0)
            System.out.print("낫싱");
    }

    private void printBall() {
        if (ball != 0)
            System.out.print(ball + "볼 ");
    }

    private void printStrike() {
        if (strike != 0)
            System.out.print(strike + "스트라이크");
    }
}
